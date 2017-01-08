package com.code1912.novelgo.bean;

import com.orm.dsl.Ignore;
import com.orm.dsl.Table;

/**
 * Created by Code1912 on 2016/12/14.
 */

@Table
public class Config {
	private long id;

	public int source=Source.LUOQIU.getIndex();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	@Ignore
	  public static final  Config  instance=new Config();

}
