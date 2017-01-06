package com.code1912.novelgo.viewmodel;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.code1912.novelgo.R;
import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.base.BaseViewModel;
import com.code1912.novelgo.bean.Novel;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;

import static android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH;

/**
 * Created by Code1912 on 2016/12/27.
 */

public class SearchViewModel extends BaseViewModel {

	public final int item_layout_id = R.layout.activity_search_item;

	@Bindable
	private String keyword = "";

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Bindable
	public ObservableArrayList<Novel> novelList = new ObservableArrayList<>();

	public SearchViewModel(BaseActivity context) {
		super(context);
	}

	public AdapterView.OnItemClickListener onItemClick = (v, v1, position, v3) -> {

	};

	public TextView.OnEditorActionListener onSearch = (view, actionId, keyEvent) -> {

		if (actionId == EditorInfo.IME_ACTION_SEARCH
			|| (keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

			if (keyword == null || "".equals(keyword)) {
				return true;
			} else {
				InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
			}
			return true;
		}
		return false;
	};
}
