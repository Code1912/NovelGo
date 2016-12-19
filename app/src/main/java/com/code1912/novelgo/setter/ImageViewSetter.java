package com.code1912.novelgo.setter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.code1912.novelgo.R;
import com.code1912.novelgo.application.AppContext;

/**
 * Created by Code1912 on 2016/12/19.
 */

public class ImageViewSetter {
	@BindingAdapter({"image_url"})
	public static void imageLoader(ImageView imageView, String url) {
		Glide.clear(imageView);

		Glide.with(AppContext.getInstance().getApplicationContext())
			.load(url)
			.centerCrop()
			.crossFade()
			.diskCacheStrategy(DiskCacheStrategy.SOURCE)
			.placeholder(R.mipmap.ic_launcher).into(imageView);
	}
}
