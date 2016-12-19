package com.code1912.novelgo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.bean.Test;
import com.code1912.novelgo.databinding.ActivityMainBinding;
import com.code1912.novelgo.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {
	MainViewModel viewModel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActivityView(R.layout.activity_main,false);
		ActivityMainBinding binding;
		viewModel = new MainViewModel(this);
		setViewModel(viewModel);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.main_search) {
		//	Intent intent = new Intent(MainActivity.this, SearchActivity.class);
		//	startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void doClick(View view) {
		//Test s=new Test();
		//s.setText("11111111111");
	//	viewModel.setTest(s);

		viewModel.getTest().setText("1111");
	}

}
