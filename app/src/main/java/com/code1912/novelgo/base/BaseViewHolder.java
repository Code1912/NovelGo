package com.code1912.novelgo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Code1912 on 2016/12/15.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

	public BaseViewHolder(View itemView) {
		super(itemView);
	}

	public abstract void setViewInfo(Context context, T info);


	protected  <T> T findView(int id){
		return  (T)itemView.findViewById(id);
	}

	protected OnItemChildClick<T> onItemChildClick;

	public void setOnItemChildClick(OnItemChildClick<T> onItemChildClick) {
		this.onItemChildClick = onItemChildClick;
	}

	protected void callItemChildClick(View v, T data, int id) {
		if (this.onItemChildClick != null)
			this.onItemChildClick.onClick(v, data, id);
	}

	public interface OnItemChildClick<T> {
		public void onClick(View v, T data, int id);
	}

}
