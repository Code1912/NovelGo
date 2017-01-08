package com.code1912.novelgo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.code1912.novelgo.R;

/**
 * Created by Code1912 on 2016/12/27.
 */

public class PullToRefreshListView extends ListView implements AbsListView.OnScrollListener {
	//底部View
	private View footerView;
	//ListView item个数
	int totalItemCount = 0;
	//最后可见的Item
	int lastVisibleItem = 0;
	//是否加载标示
	boolean isLoading = false;

	public PullToRefreshListView(Context context) {
		super(context);
		initView(context);
	}

	public PullToRefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
		initParams(context,attrs);

	}

	public PullToRefreshListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
		initParams(context,attrs);
	}

	/**
	 * 初始化ListView
	 */
	private void initView(Context context){
		LayoutInflater mInflater = LayoutInflater.from(context);
		footerView = mInflater.inflate(R.layout.listview_footer, null);
		footerView.setVisibility(View.GONE);
		this.setOnScrollListener(PullToRefreshListView.this);
		//添加底部View
		this.addFooterView(footerView);
	}

	private void initParams(Context context, AttributeSet attrs) {
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PullToRefreshListView);
		if (typedArray != null) {
			//footerView.setVisibility(typedArray.getBoolean(R.styleable.PullToRefreshListView_showFooter, false) ? VISIBLE : GONE);
			typedArray.recycle();
		}
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		//当滑动到底端，并滑动状态为 not scrolling
		if(totalItemCount<=1){
			return;
		}
		if(lastVisibleItem == totalItemCount && scrollState == SCROLL_STATE_IDLE){
			if(!isLoading){
				isLoading = true;
				//设置可见
				footerView.setVisibility(View.VISIBLE);
				//加载数据
				if(onPullDownListener ==null){
					throw  new NullPointerException("Please set onPullDownListener.");
				}
				onPullDownListener.onLoad(this);
			}
		}
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			     int visibleItemCount, int totalItemCount) {
		this.lastVisibleItem = firstVisibleItem + visibleItemCount;
		this.totalItemCount = totalItemCount;
	}

	private OnPullDownListener onPullDownListener;
	public void setOnPullDownListener(OnPullDownListener onPullDownListener){
		this.onPullDownListener = onPullDownListener;
	}

	/**
	 * 加载数据接口
	 * @author Administrator
	 *
	 */
	public interface OnPullDownListener {
		void onLoad(PullToRefreshListView view);
	}

	/**
	 * 数据加载完成
	 */
	public void loadComplete(){
		footerView.setVisibility(View.GONE);
		isLoading = false;
		this.invalidate();
	}

}
