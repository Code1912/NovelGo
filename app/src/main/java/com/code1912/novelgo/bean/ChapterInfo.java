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
    private Long id;
    @Bindable
    private String title;
    private String url;
    private Long novel_id=0L;
    private Date add_date;
    private  Boolean is_read;
    private Integer position=0;
    private Integer chapter_index=0;
    private Boolean is_downloaded;
    @Transient
    private Boolean is_current;
    private Integer type=0;
    @Generated(hash = 621561915)
    public ChapterInfo(Long id, String title, String url, Long novel_id, Date add_date, Boolean is_read,
            Integer position, Integer chapter_index, Boolean is_downloaded, Integer type) {
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
    public Long getId() {
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
    public Long getNovel_id() {
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
    public Boolean getIs_read() {
        return this.is_read;
    }
    public void setIs_read(Boolean is_read) {
        this.is_read = is_read;
    }
    public Integer getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public Integer getChapter_index() {
        return this.chapter_index;
    }
    public void setChapter_index(int chapter_index) {
        this.chapter_index = chapter_index;
    }
    public Boolean getIs_downloaded() {
        return this.is_downloaded;
    }
    public void setIs_downloaded(Boolean is_downloaded) {
        this.is_downloaded = is_downloaded;
    }
    public Boolean getIs_current() {
        return this.is_current;
    }
    public void setIs_current(Boolean is_current) {
        this.is_current = is_current;
    }
    public Integer getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNovel_id(Long novel_id) {
        this.novel_id = novel_id;
    }
    public void setPosition(Integer position) {
        this.position = position;
    }
    public void setChapter_index(Integer chapter_index) {
        this.chapter_index = chapter_index;
    }
    public void setType(Integer type) {
        this.type = type;
    }
}
