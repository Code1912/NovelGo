package com.code1912.novelgo.setter;

import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;

import com.code1912.novelgo.view.PullToRefreshListView;

/**
 * Created by Code1912 on 2017/1/8.
 */

public class PullListViewSetter {
	@BindingAdapter({"onPullDown"})
	public static void bindOnPullDown(PullToRefreshListView view, PullToRefreshListView.OnPullDownListener listener) {
		if (listener != null) {
			view.setOnPullDownListener(listener);
		}
	}

	@BindingAdapter({"showFooter"})
	public static void bindLoadCompleted(PullToRefreshListView view, boolean val) {
		if (!val) {
			view.loadComplete();
		}
	}
}
