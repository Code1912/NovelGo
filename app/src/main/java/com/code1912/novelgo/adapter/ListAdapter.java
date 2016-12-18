package com.code1912.novelgo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.code1912.novelgo.base.BaseViewHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class ListAdapter<T> extends BaseAdapter {
	List<T> dataList = new ArrayList<T>();
	Context context;
	LayoutInflater layoutInflater;
	Class<BaseViewHolder> holderClass;
	BaseViewHolder.OnItemChildClick<T> onItemChildClick;
	BaseViewHolder holder;
	Integer itemViewId;

	public ListAdapter(Context context, Class<BaseViewHolder> holderClass, int viewId) {
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
		this.holderClass = holderClass;
		this.itemViewId = viewId;
	}

	@Override
	public int getCount() {
		return this.dataList.size();
	}

	@Override
	public Object getItem(int i) {
		return dataList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	public void addDataList(List<T> novels) {
		if (novels == null || novels.size() == 0) {
			return;
		}
		this.dataList.addAll(novels);
		this.notifyDataSetChanged();
	}

	public List<T> getDataList() {
		return this.dataList;
	}

	public void addData(T data) {
		this.dataList.add(data);
		this.notifyDataSetChanged();
	}

	public void addData(int index, T data) {
		this.dataList.add(index, data);
		this.notifyDataSetChanged();
	}

	public void removeAt(int index) {
		this.dataList.remove(index);
		this.notifyDataSetChanged();
	}

	public void removeAll() {
		if (dataList == null || dataList.size() == 0) {
			return;
		}
		this.dataList.clear();
		this.notifyDataSetChanged();
	}

	public void setOnItemChildClick(BaseViewHolder.OnItemChildClick<T> onItemChildClick) {
		this.onItemChildClick = onItemChildClick;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(this.itemViewId, null);
			try {
				Class[] argsClass = new Class[1];
				argsClass[0] = View.class;
				Constructor cons = holderClass.getConstructor(argsClass);
				holder = (BaseViewHolder) cons.newInstance(new Object[]{convertView});
				convertView.setTag(holder);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		} else {
			holder = (BaseViewHolder) convertView.getTag();
		}
		holder.setViewInfo(context, this.dataList.get(position));
		holder.setOnItemChildClick(this.onItemChildClick);
		return convertView;
	}
}
