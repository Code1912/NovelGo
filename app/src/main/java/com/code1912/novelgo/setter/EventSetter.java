package com.code1912.novelgo.setter;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;

import com.code1912.novelgo.adapter.ListAdapter;
import com.code1912.novelgo.base.BaseViewModel;

/**
 * Created by Code1912 on 2016/12/25.
 */

public class EventSetter {
	@BindingAdapter({"onTouch","onTouchData"})
	public static <T> void bindOnTouch(View view , ProxyOnTouchListener<T> onTouchListener, @Nullable  T data) {
	     if (onTouchListener!=null){
		     view.setOnTouchListener((v,m)-> onTouchListener.onTouch(v,m,data)  );
	     }
	}

	@BindingAdapter({"onLongClick" ,"onLongClickData"})
	public static  <T> void bindOnLongClick(View view ,  ProxyOnLongClickListener<T> listener,  @Nullable T data) {
		if (listener!=null){
			view.setOnLongClickListener(v->listener.onLongClick(v,data));
		}
	}

	@BindingAdapter({"onClick" ,"onClickData"})
	public static  <T> void bindOnClick(View view ,  ProxyOnClickListener<T> listener, @Nullable T data) {
		if (listener!=null){
			view.setOnClickListener(v->listener.onClick(v,data));
		}
	}

	public  interface   ProxyOnTouchListener<T>{
		boolean onTouch(View var1, MotionEvent var2,T data);
	}
	public  interface   ProxyOnLongClickListener<T>{
		boolean onLongClick(View var1,T data);
	}
	public  interface   ProxyOnClickListener<T>{
		void onClick(View var1,T data);
	}
}
