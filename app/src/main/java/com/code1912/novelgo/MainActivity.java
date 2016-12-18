package com.code1912.novelgo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.bean.Test;
import com.code1912.novelgo.databinding.ActivityMainBinding;
import com.code1912.novelgo.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView(R.layout.activity_main);
		MainViewModel viewModel=new MainViewModel(this);
		setViewModel(viewModel);
	}

}
