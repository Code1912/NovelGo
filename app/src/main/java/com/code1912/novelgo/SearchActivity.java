package com.code1912.novelgo;

import android.os.Bundle;

import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.viewmodel.MainViewModel;
import com.code1912.novelgo.viewmodel.SearchViewModel;

/**
 * Created by Code1912 on 2016/12/27.
 */

public class SearchActivity extends BaseActivity {
	SearchViewModel viewModel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActivityView(R.layout.activity_main,false);
		viewModel = new SearchViewModel(this);
		setViewModel(viewModel);
	}
}
