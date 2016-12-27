package com.code1912.novelgo.setter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
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

	@BindingAdapter({"onItemLongClick"})
	public static void   bindOnTouch(AdapterView view,AdapterView.OnItemLongClickListener longClickListener) {
		if (longClickListener!=null){
			view.setOnItemLongClickListener(longClickListener);
		}
	}

	@BindingAdapter({"onItemClick"})
	public static void   bindOnTouch(AdapterView view,AdapterView.OnItemClickListener longClickListener) {
		if (longClickListener!=null){
			view.setOnItemClickListener(longClickListener);
		}
	}
}

