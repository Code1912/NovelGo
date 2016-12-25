package com.code1912.novelgo.setter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;

import com.code1912.novelgo.adapter.ListAdapter;
import com.code1912.novelgo.base.BaseViewModel;

/**
 * Created by Code1912 on 2016/12/19.
 */

public class ListViewSetter {
	@BindingAdapter({"items", "layout_id", "view_model"})
	public static <Observable> void bindList(AbsListView view, ObservableArrayList<Observable> items, int layoutId, BaseViewModel viewModel) {
		ListAdapter<Observable> adapter = new ListAdapter<Observable>(items, layoutId,viewModel);
		view.setAdapter(adapter);
	}
}

