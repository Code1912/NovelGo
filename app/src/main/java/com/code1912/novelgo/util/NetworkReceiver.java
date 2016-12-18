package com.code1912.novelgo.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class NetworkReceiver extends BroadcastReceiver {
	OnNetworkChangedListener onNetworkChangedListener;
	public  void onReceive(Context context, Intent intent) {
		ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if(!activeNetwork.isConnected())
		{
			Toast.makeText(context, "网络连接断开，请检查网络连接.", Toast.LENGTH_SHORT).show();
		}
		if(onNetworkChangedListener!=null){
			onNetworkChangedListener.onNetworkChanged(activeNetwork.isConnected());
		}
	}

	public   void setOnNetworkChangedListener(OnNetworkChangedListener listener){
		this.onNetworkChangedListener=listener;
	}

	public  interface  OnNetworkChangedListener{
		void  onNetworkChanged(boolean isConnected);
	}
}
