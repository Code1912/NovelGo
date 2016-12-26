package com.code1912.novelgo.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.v4.widget.SwipeRefreshLayout;

import com.android.databinding.library.baseAdapters.BR;
import com.code1912.novelgo.R;
import com.code1912.novelgo.annotaion.ListItemEvent;
import com.code1912.novelgo.base.BaseActivity;
import com.code1912.novelgo.base.BaseViewModel;
import com.code1912.novelgo.bean.Novel;
import com.code1912.novelgo.biz.NovelBiz;
import com.code1912.novelgo.service.NovelService;
import com.code1912.novelgo.setter.EventSetter;
import com.code1912.novelgo.util.Util;

import org.apache.calcite.linq4j.Linq4j;

import java.util.List;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class MainViewModel extends BaseViewModel {
	public int getItem_layout_id() {
		return item_layout_id;
	}

	public void setItem_layout_id(int item_layout_id) {
		this.item_layout_id = item_layout_id;
	}
	public final ObservableBoolean refreshing = new ObservableBoolean(false);


	@Bindable
	private int item_layout_id = R.layout.activity_main_item;

	@Bindable
	ObservableArrayList<Novel> novelList = new ObservableArrayList<>();

	public MainViewModel(BaseActivity context) {
		super(context);
		init();
	}

	public SwipeRefreshLayout.OnRefreshListener onRefresh= () ->{
		for (Novel novel : novelList) {
			refresh(novel);
		}
	 };

	private void refresh(Novel novel) {
		NovelService.instance.chapterInfo(novel.getCurrent_url(), novel.getType()).subscribe(
			(response) -> {
				if (response.resultList.size() > novel.getAll_chapter_count()) {
					novel.setHasNew(true);
					NovelBiz.getInstance().updateNovelIsHaveNew(novel.getId(), novel.getHasNew());
				}
			}, (error) -> {

			}, () -> {
				novel.setRefreshed(true);
				if (!Linq4j.asEnumerable(novelList).all(p -> p.isRefreshed())) {
					return;
				}
				refreshing.set(false);
			});
	}

	@ListItemEvent(variableId = BR.item_touch)
	public EventSetter.ProxyOnTouchListener<Novel> onItemTouch = (v1, v2, data) -> {
		return data.getShowTrash();
	};

	@ListItemEvent(variableId = BR.item_long_click)
	public EventSetter.ProxyOnLongClickListener<Novel> onItemLongClick = (v1, data) -> {
		for (Novel novel : novelList) {
			novel.setShowTrash(true);
		}
		return data.getShowTrash();
	};

	@ListItemEvent(variableId = BR.item_click)
	public EventSetter.ProxyOnClickListener<Novel> onItemClick = (v1, data) -> {
		//data.setIsShowTrash(true);
	};

	@ListItemEvent(variableId = BR.item_remove_click)
	public EventSetter.ProxyOnClickListener<Novel> onItemRemoveClick = (v1, data) -> {
		this.novelList.remove(data);
		NovelBiz.getInstance().deleteNovel(data.getId());
	};

	private void init() {
		Novel novel = new Novel();
		novel.setName("test");
		novel.setAdd_date(Util.getCurrentDate());
		NovelBiz.getInstance().addNovel(novel);
		List<Novel> list = NovelBiz.getInstance().getAllNovels();
		if (list != null) {
			novelList.addAll(list);
		}


	}

	public ObservableArrayList<Novel> getNovelList() {
		return novelList;
	}

	public void setNovelList(ObservableArrayList<Novel> novelList) {
		this.novelList = novelList;
	}
}