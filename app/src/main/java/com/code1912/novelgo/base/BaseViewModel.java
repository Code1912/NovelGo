package com.code1912.novelgo.base;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class BaseViewModel {
	protected BaseActivity context;

	public BaseViewModel(BaseActivity context) {
		this.context = context;
	}
}
