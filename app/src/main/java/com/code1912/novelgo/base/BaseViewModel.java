package com.code1912.novelgo.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class BaseViewModel extends BaseObservable {
	public BaseActivity context;

	public Boolean getShowLoading() {
		return showLoading;
	}


	@Bindable
	private    Boolean showLoading=false;


	public void setShowLoading(Boolean showLoading) {
		showLoading = showLoading;
		notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.showLoading);
	}

	public BaseViewModel(BaseActivity context) {
		this.context = context;
	}
}
