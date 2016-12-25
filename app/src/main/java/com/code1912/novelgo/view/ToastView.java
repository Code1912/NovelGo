package com.code1912.novelgo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.code1912.novelgo.R;

/**
 * Created by Code1912 on 2016/12/25.
 */

public   class ToastView extends LinearLayout {
	TextView textView;

	public ToastView(Context context) {
		super(context);
		init(context);
	}

	public ToastView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ToastView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		LayoutInflater.from(context).inflate(R.layout.view_toast, this);
		textView = (TextView) this.findViewById(R.id.toast_text);
	}

	public void setText(String msg) {
		if (textView != null) {
			textView.setText(msg);
		}
	}
}
