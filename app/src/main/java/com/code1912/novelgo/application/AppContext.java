package com.code1912.novelgo.application;

import android.app.Application;
import android.content.Context;

import com.code1912.novelgo.biz.NovelBiz;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.orm.SugarContext;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class AppContext extends Application {

	private static AppContext singleton;
	public static AppContext getInstance(){
		return singleton;
	}

	@Override
	public final void onCreate() {
		super.onCreate();
		singleton = this;

		Iconics.init(getApplicationContext());
		//register custom fonts like this (or also provide a font definition file)
		Iconics.registerFont(new FontAwesome());

		SugarContext.init(this);
		NovelBiz.getInstance().init();
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(IconicsContextWrapper.wrap(base));
	}

	@Override
	public void onTerminate() {
		SugarContext.terminate();
		super.onTerminate();
	}
}
