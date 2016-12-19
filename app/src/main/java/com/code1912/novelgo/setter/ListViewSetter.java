package com.code1912.novelgo.setter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.widget.ListView;

import com.code1912.novelgo.adapter.ListAdapter;
import com.code1912.novelgo.base.BaseViewModel;

/**
 * Created by Code1912 on 2016/12/19.
 */

public class ListViewSetter {
	@BindingAdapter({"items", "layout_id", "view_model"})
	public static <T> void bindList(ListView view, ObservableArrayList<T> items, int layoutId, BaseViewModel viewModel) {
		ListAdapter<T> adapter = new ListAdapter<T>(items, layoutId,viewModel);
		view.setAdapter(adapter);
		view.getAdapter();
	}
}

