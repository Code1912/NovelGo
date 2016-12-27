package com.code1912.novelgo.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.widget.AdapterView;

import com.code1912.novelgo.R;
import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.base.BaseViewModel;
import com.code1912.novelgo.bean.Novel;

/**
 * Created by Code1912 on 2016/12/27.
 */

public class SearchViewModel extends BaseViewModel {

	public final int item_layout_id = R.layout.activity_main_item;

	@Bindable
	ObservableArrayList<Novel> novelList = new ObservableArrayList<>();

	public SearchViewModel(BaseActivity context) {
		super(context);
	}

	public AdapterView.OnItemClickListener onItemClick = (v, v1, position, v3) -> {

	};
}
