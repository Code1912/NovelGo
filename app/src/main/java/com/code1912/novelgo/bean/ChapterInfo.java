package com.code1912.novelgo.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.orm.dsl.Ignore;
import com.orm.dsl.Table;



import java.io.Serializable;
import java.util.Date;
import java.util.Observable;


/**
 * Created by Code1912 on 2016/12/3.
 */

@Table
public class ChapterInfo  extends BaseObservable {

    private long id;
    @Bindable
    private String title;
    private String url;
    private long novel_id = 0L;
    private Date add_date;
    private boolean is_read;
    private int position = 0;
    private int chapter_index = 0;
    private boolean is_downloaded;
    @Ignore
    private boolean is_current;
    private int type = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getNovel_id() {
        return novel_id;
    }

    public void setNovel_id(long novel_id) {
        this.novel_id = novel_id;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public boolean is_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getChapter_index() {
        return chapter_index;
    }

    public void setChapter_index(int chapter_index) {
        this.chapter_index = chapter_index;
    }

    public boolean is_downloaded() {
        return is_downloaded;
    }

    public void setIs_downloaded(boolean is_downloaded) {
        this.is_downloaded = is_downloaded;
    }

    public boolean is_current() {
        return is_current;
    }

    public void setIs_current(boolean is_current) {
        this.is_current = is_current;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
