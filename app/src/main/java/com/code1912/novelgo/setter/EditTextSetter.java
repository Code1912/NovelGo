package com.code1912.novelgo.setter;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.TextView;

import com.code1912.novelgo.adapter.ListAdapter;
import com.code1912.novelgo.base.BaseViewModel;

/**
 * Created by Code1912 on 2017/1/6.
 */

public class EditTextSetter {
	@BindingAdapter({"onAction"})
	public static  void bindOnAction(EditText editText, TextView.OnEditorActionListener onEditorActionListener) {
		editText.setOnEditorActionListener(onEditorActionListener);
	}
}
