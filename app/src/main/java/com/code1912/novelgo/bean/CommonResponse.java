package com.code1912.novelgo.bean;

import java.util.List;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class CommonResponse<T> {
	public boolean success;
	public String message;
	public List<T> resultList;
	public T result;
	public int pageIndex;
	public int totalCount;
}
