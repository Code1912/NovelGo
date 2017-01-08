package com.code1912.novelgo.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class BaseViewModel extends BaseObservable {
	public BaseActivity context;

	public ObservableBoolean showLoading=new ObservableBoolean(false);

	public BaseViewModel(BaseActivity context) {
		this.context = context;
	}
}
