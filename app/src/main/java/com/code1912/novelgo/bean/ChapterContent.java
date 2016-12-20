package com.code1912.novelgo.bean;

import android.databinding.Bindable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Code1912 on 2016/12/20.
 */
@Entity
public class ChapterContent {

	@Id(autoincrement = false)
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

	public  ChapterContent(){

	}

	@Generated(hash = 2032736143)
	public ChapterContent(long chapterId, String content) {
					this.chapterId = chapterId;
					this.content = content;
	}

}
