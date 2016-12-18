package com.code1912.novelgo.bean;

import com.code1912.novelgo.util.Util;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Date;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class Novel extends SugarRecord {
	public  String author_name;
	public  long dateModified;
	public  String  description  ;
	public  String genre;
	public  String genre_index;
	public  String image;
	public String current_url;
	public  String  name;
	public  String newestChapter_headline;
	public  String  newestChapter_url;
	public  long  totalClick;
	public  String  trialStatus;
	public  String updateStatus;
	public  String  url;
	public  long  wordCount;
	public  long read_chapter_count;
	public int all_chapter_count;
	public boolean is_have_new;
	public  int last_chapter_index;
	@Ignore
	public  boolean refreshed;
	@Ignore
	public  boolean isShowTrash;
	public Date add_date;
	public  String getLastEditDate(){
		return    Util.getStrTime(this.dateModified,"yyyy-MM-dd HH:MM:ss");
	}
	public int type;
	public Novel(){

	}
}
