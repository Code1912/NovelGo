package com.code1912.novelgo.viewmodel;

import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.base.BaseViewModel;
import com.code1912.novelgo.bean.Test;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class MainViewModel extends BaseViewModel {
	public MainViewModel(BaseActivity context) {
		super(context);
		this.test=new Test();
		test.text="afdasdf";
	}
	public Test test;
}
