package com.code1912.novelgo.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by Code1912 on 2016/12/3.
 */

@Entity
public class ChapterInfo  extends BaseObservable {
    @Id(autoincrement = true)
    private long id;
    @Bindable
    private String title;
    private String url;
    private long novel_id;
    private Date add_date;
    private  boolean is_read;
    private int position;
    private  int chapter_index;
    private boolean is_downloaded;
    @Transient
    private boolean is_current;
    private  int type;
   @Generated(hash = 1404805228)
public ChapterInfo(long id, String title, String url, long novel_id,
        Date add_date, boolean is_read, int position, int chapter_index,
        boolean is_downloaded, int type) {
    this.id = id;
    this.title = title;
    this.url = url;
    this.novel_id = novel_id;
    this.add_date = add_date;
    this.is_read = is_read;
    this.position = position;
    this.chapter_index = chapter_index;
    this.is_downloaded = is_downloaded;
    this.type = type;
}
@Generated(hash = 1687309083)
public ChapterInfo() {
}
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public long getNovel_id() {
        return this.novel_id;
    }
    public void setNovel_id(long novel_id) {
        this.novel_id = novel_id;
    }
    public Date getAdd_date() {
        return this.add_date;
    }
    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }
    public boolean getIs_read() {
        return this.is_read;
    }
    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getChapter_index() {
        return this.chapter_index;
    }
    public void setChapter_index(int chapter_index) {
        this.chapter_index = chapter_index;
    }
    public boolean getIs_downloaded() {
        return this.is_downloaded;
    }
    public void setIs_downloaded(boolean is_downloaded) {
        this.is_downloaded = is_downloaded;
    }
    public boolean getIs_current() {
        return this.is_current;
    }
    public void setIs_current(boolean is_current) {
        this.is_current = is_current;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
}
