package com.code1912.novelgo.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.code1912.novelgo.annotaion.ListItemEvent;
import com.code1912.novelgo.base.BaseViewModel;
import com.android.databinding.library.baseAdapters.BR;
import org.apache.calcite.linq4j.Linq4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * Created by Code1912 on 2016/12/15.
 */

public class ListAdapter<T> extends BaseAdapter {
	ObservableArrayList<T> items;
	Context context;
	LayoutInflater layoutInflater;
	Integer itemViewId;
	HashMap<Integer,Object> eventsMap=new HashMap<Integer, Object>() ;
	BaseViewModel viewModel;

	public ListAdapter(ObservableArrayList<T> items, int viewId, BaseViewModel viewModel) {
		this.context = viewModel.context;
		this.layoutInflater = LayoutInflater.from(context);
		this.itemViewId = viewId;
		this.items =items;
		this.viewModel=viewModel;
		getEvents();
	}

	private  void getEvents() {
		Field[] fields = this.viewModel.getClass().getFields();
		for (Field field : fields) {
			ListItemEvent annotation = field.getAnnotation(ListItemEvent.class);
			if (annotation == null||annotation.variableId()==-1||eventsMap.containsKey(annotation.variableId())) {
				continue;
			}
			try {
				Object handler=field.get(viewModel);
				if(handler==null){
					continue;
				}
				eventsMap.put(annotation.variableId(),handler);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public int getCount() {
		return this.items.size();
	}

	@Override
	public Object getItem(int i) {
		return items.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	public List<T> getItems() {
		return this.items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewDataBinding binding=null;
		if(convertView==null){
			 binding = DataBindingUtil.inflate(layoutInflater, itemViewId, parent, false);
			Iterator iterator = eventsMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				Integer key =(Integer) entry.getKey();
				binding.setVariable(key, entry.getValue());
			}
			convertView=binding.getRoot();
		}
		else {
			binding=DataBindingUtil.getBinding(convertView);
		}
		binding.setVariable(BR.item, items.get(position));
		return convertView;
	}
}
