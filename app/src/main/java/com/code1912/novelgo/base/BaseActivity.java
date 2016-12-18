package com.code1912.novelgo.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.code1912.novelgo.R;
import com.code1912.novelgo.databinding.ActivityMainBinding;
import com.code1912.novelgo.util.NetworkReceiver;

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

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	protected void initView(Integer layoutId) {
		setContentView(layoutId);
		viewDataBinding = DataBindingUtil.setContentView(this, layoutId);
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

	public <T> void setEntity(T entity) {
		try {
			Class<?> entityClass = entity.getClass();
			Method method = viewDataBinding.getClass().getMethod(String.format("set%s", entityClass.getSimpleName()), entityClass);
			if (method != null) {
				method.invoke(viewDataBinding, entity);
			}
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
	}

	public <T> void setViewModel(T entity) {
		try {
			Class<?> entityClass = entity.getClass();
			Method method = viewDataBinding.getClass().getMethod("setVM", entityClass);
			if (method != null) {
				method.invoke(viewDataBinding, entity);
			}
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
	}

	public void registerNetworkWatch() {
		networkReceiver = new NetworkReceiver();
		networkReceiver.setOnNetworkChangedListener(this);
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		this.registerReceiver(networkReceiver, intentFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(networkReceiver);
	}

	@Override
	public void onNetworkChanged(boolean isConnected) {

	}
}
