package com.code1912.novelgo.bean;

import android.databinding.Bindable;

import com.orm.dsl.Table;
/**
 * Created by Code1912 on 2016/12/20.
 */
@Table
public class ChapterContent {
	public ChapterContent(long chapterId, String content) {
		this.chapterId = chapterId;
		this.content = content;
	}
        private  long id;
	private long chapterId;

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getChapterId() {
		return chapterId;
	}

	public void setChapterId(long chapterId) {
		this.chapterId = chapterId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
