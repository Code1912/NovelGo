package com.code1912.novelgo.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.code1912.novelgo.R;
import com.code1912.novelgo.databinding.ActivityMainBinding;
import com.code1912.novelgo.util.NetworkReceiver;
import com.code1912.novelgo.view.LoadingView;

import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.NoSuchElementException;

/**
 * Created by Code1912 on 2016/12/14.
 */

public class BaseActivity extends AppCompatActivity implements NetworkReceiver.OnNetworkChangedListener {
	NetworkReceiver networkReceiver;
	protected ViewDataBinding viewDataBinding;
        protected  LoadingView loadingView;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void setActivityView(@LayoutRes int  layoutId,boolean showBackBtn) {
		viewDataBinding = DataBindingUtil.setContentView(this, layoutId);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(showBackBtn);
		//toolbar.setNavigationOnClickListener(v -> SearchActivity.this.finish());
		loadingView = findView(R.id.loading_view);

	}
	public void setActivityView(@LayoutRes int  layoutId) {
		setActivityView(layoutId,true);
	}
	private ViewGroup getRootView()
	{
		return findView(android.R.id.content);
	}
	public <T> T findView(int id) {
		return (T) this.findViewById(id);
	}

	public void showToast(String msg) {
		runOnUiThread(() -> {
			Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
			toast.show();
		});
	}

	public void showLoading() {

	}

	public void hideLoading() {

	}


	public void doBack(View view) {
		onBackPressed();
	}

	public <T> void setEntity(int variableId,T entity) {
		 viewDataBinding.setVariable(variableId,entity);
	}

	public <T> void setViewModel(T entity) {
		viewDataBinding.setVariable(BR.VM,entity);
	}

	public void registerNetworkWatch() {
		networkReceiver = new NetworkReceiver();
		networkReceiver.setOnNetworkChangedListener(this);
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		this.registerReceiver(networkReceiver, intentFilter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (networkReceiver != null) {
			IntentFilter intentFilter = new IntentFilter();
			intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
			this.registerReceiver(networkReceiver, intentFilter);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (networkReceiver != null)
			unregisterReceiver(networkReceiver);
	}

	@Override
	public void onNetworkChanged(boolean isConnected) {

	}
}
