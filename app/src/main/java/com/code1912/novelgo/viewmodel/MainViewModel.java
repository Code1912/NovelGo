package com.code1912.novelgo.viewmodel;

import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.base.BaseViewModel;
import com.code1912.novelgo.bean.Test;
import com.code1912.novelgo.databinding.ActivityMainBinding;
import com.code1912.novelgo.databinding.ActivityMainItemBinding;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class MainViewModel extends BaseViewModel {
	public MainViewModel(BaseActivity context) {
		super(context);
		this.test=new Test();
		test.setText("22222");

	}
	@Bindable
	private Test test;
	public void  setTest( Test val){
		this.test=val;
		notifyPropertyChanged(BR.test);
	}
	public  Test getTest(){
		return this.test;
	}
}
