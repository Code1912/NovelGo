package com.code1912.novelgo.application;

import android.app.Application;
import android.content.Context;

import com.code1912.novelgo.bean.DaoMaster;
import com.code1912.novelgo.bean.DaoSession;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.context.IconicsContextWrapper;


/**
 * Created by Code1912 on 2016/12/15.
 */
import org.greenrobot.greendao.database.Database;

public class AppContext extends Application {
        static DaoSession daoSession;
	private static AppContext singleton;
	public static AppContext getInstance(){
		return singleton;
	}

	public  static DaoSession getDaoSession(){
		return  daoSession;
	}
	@Override
	public final void onCreate() {
		super.onCreate();
		singleton = this;
		DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "novelGo-db");
		Database db = helper.getWritableDb();
		daoSession = new DaoMaster(db).newSession();
		Iconics.init(getApplicationContext());
		//register custom fonts like this (or also provide a font definition file)
		Iconics.registerFont(new FontAwesome());
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(IconicsContextWrapper.wrap(base));
	}

	@Override
	public void onTerminate() {

		super.onTerminate();
	}
}
