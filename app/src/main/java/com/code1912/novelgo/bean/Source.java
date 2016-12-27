package com.code1912.novelgo.bean;

/**
 * Created by Code1912 on 2016/12/27.
 */

public enum Source {
	LUOQIU("落秋中文", 1), BIQUGE("笔趣阁", 2);
	// 成员变量
	private String name;
	private int index;
	// 构造方法
	private Source(String name, int index) {
		this.name = name;
		this.index = index;
	}
	// 普通方法
	public static String getName(int index) {
		for (Source c : Source.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}
	// get set 方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
