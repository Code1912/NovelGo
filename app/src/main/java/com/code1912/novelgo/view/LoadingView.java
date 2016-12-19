package com.code1912.novelgo.view;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.code1912.novelgo.R;
import com.code1912.novelgo.base.BaseViewModel;


/**
 * Created by Code1912 on 2016/12/19.
 */

public class LoadingView  extends LinearLayout {
	private ImageView imageView;
	private  boolean isShow=false;
	public LoadingView(Context context) {
		super(context);
		init(context);
	}

	public LoadingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		LayoutInflater.from(context).inflate(R.layout.view_loading, this);
		imageView = (ImageView) findViewById(R.id.loading_img);
		if (context != null&&this.imageView!=null) {
			try {
				Glide.clear(this.imageView);
				Glide.with(context)
					.load(R.mipmap.loading).asGif().into(this.imageView);
			}
			catch (NullPointerException ex){
				ex.printStackTrace();
			}
		}
		this.bringToFront();
		this.setOnTouchListener((v,e)->  isShow );
		hide();
	}

	public void show() {
		this.setVisibility(VISIBLE);
		this.isShow=true;
	}

	public void hide() {
		this.setVisibility(GONE);
		this.isShow=false;
	}

}
