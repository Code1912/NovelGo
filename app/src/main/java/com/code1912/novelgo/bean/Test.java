package com.code1912.novelgo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class Test extends  BaseObservable {
       @Bindable
	private String text;
	public  String getText(){
		return  text;
	}
	public void setText(String val){
		text=val;
		notifyPropertyChanged(BR.text);
	}
}
