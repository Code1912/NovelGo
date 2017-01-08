package com.code1912.novelgo.viewmodel;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.TextView;

import com.code1912.novelgo.R;
import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.base.BaseViewModel;
import com.code1912.novelgo.bean.Config;
import com.code1912.novelgo.bean.Novel;
import com.code1912.novelgo.service.NovelService;
import com.code1912.novelgo.util.Util;
import com.code1912.novelgo.view.PullToRefreshListView;

import io.reactivex.schedulers.Schedulers;

/**
 * Created by Code1912 on 2016/12/27.
 */

public class SearchViewModel extends BaseViewModel {

        public ObservableInt item_layout_id=new ObservableInt(R.layout.activity_search_item);
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

			if (keyword == null || "".equals(keyword)||showLoading.get()) {
				return true;
			} else {
				InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
				mTotalCount = 0;
				mPageIndex = 0;
				mKeyword = keyword;
				novelList.clear();
				SearchViewModel.this.search();
			}
			return true;
		}
		return false;
	};

	public PullToRefreshListView.OnPullDownListener onPullDownListener=(view)->{
		if(Util.isNullOrEmpty(SearchViewModel.this.mKeyword)){
			view.loadComplete();
			return;
		}
		if (novelList.size() > 0 && novelList.size() ==SearchViewModel.this.mTotalCount) {
			context.showToast("没有更多了");
			 view.loadComplete();
			return;
		}
		search();
	};

	private int mTotalCount = 0;
	private int mPageIndex = 0;
	private String mKeyword = "";

	private void search() {
		if (novelList.size() > 0 && novelList.size() == mTotalCount) {
			context.showToast("没有更多了");
			showLoading.set(false);
			return;
		}
		showLoading.set(true);
		NovelService.instance.search(mKeyword, mPageIndex + 1, Config.instance.getSource())
			.subscribeOn(Schedulers.newThread()).subscribe((response) -> {
			if (!response.success || response.resultList == null || response.resultList.size() == 0) {
				return;
			}
			novelList.addAll(response.resultList);
			mTotalCount = response.totalCount;
			mPageIndex = response.pageIndex;
		}, (error) -> {
			context.showToast("异常了word哥:" + error.getMessage());
		}, () -> {
			showLoading.set(false);
		});
	}
}