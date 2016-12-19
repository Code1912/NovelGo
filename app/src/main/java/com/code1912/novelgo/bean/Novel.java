package com.code1912.novelgo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.code1912.novelgo.util.Util;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by Code1912 on 2016/12/18.
 */

@Entity
public class Novel extends BaseObservable {
	@Id(autoincrement = true)
	private long id;
	private String author_name;
	private long dateModified;
	private String description;
	private String genre;
	private String genre_index;
	@Bindable
	public String image;
	private String current_url;
	@Bindable
	private String name;
	private String newestChapter_headline;
	private String newestChapter_url;
	private long totalClick;
	private String trialStatus;
	private String updateStatus;
	private String url;
	private long wordCount;
	@Bindable
	private long read_chapter_count;
	@Bindable
	private int all_chapter_count;
	@Bindable
	private boolean is_have_new;
	private int last_chapter_index;
	@Transient
	private boolean refreshed;
	@Bindable
	@Transient
	private boolean isShowTrash;
	private Date add_date;

	public String getLastEditDate() {
		return Util.getStrTime(this.dateModified, "yyyy-MM-dd HH:MM:ss");
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor_name() {
		return this.author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public long getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(long dateModified) {
		this.dateModified = dateModified;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre_index() {
		return this.genre_index;
	}

	public void setGenre_index(String genre_index) {
		this.genre_index = genre_index;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
		notifyPropertyChanged(BR.image);
	}

	public String getCurrent_url() {
		return this.current_url;
	}

	public void setCurrent_url(String current_url) {
		this.current_url = current_url;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}

	public String getNewestChapter_headline() {
		return this.newestChapter_headline;
	}

	public void setNewestChapter_headline(String newestChapter_headline) {
		this.newestChapter_headline = newestChapter_headline;
	}

	public String getNewestChapter_url() {
		return this.newestChapter_url;
	}

	public void setNewestChapter_url(String newestChapter_url) {
		this.newestChapter_url = newestChapter_url;
	}

	public long getTotalClick() {
		return this.totalClick;
	}

	public void setTotalClick(long totalClick) {
		this.totalClick = totalClick;
	}

	public String getTrialStatus() {
		return this.trialStatus;
	}

	public void setTrialStatus(String trialStatus) {
		this.trialStatus = trialStatus;
	}

	public String getUpdateStatus() {
		return this.updateStatus;
	}

	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getWordCount() {
		return this.wordCount;
	}

	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	public long getRead_chapter_count() {
		return this.read_chapter_count;
	}

	public void setRead_chapter_count(long read_chapter_count) {
		this.read_chapter_count = read_chapter_count;
	}

	public int getAll_chapter_count() {
		return this.all_chapter_count;
	}

	public void setAll_chapter_count(int all_chapter_count) {
		this.all_chapter_count = all_chapter_count;
		notifyPropertyChanged(BR.all_chapter_count
		);
	}

	public boolean getIs_have_new() {
		return this.is_have_new;
	}

	public void setIs_have_new(boolean is_have_new) {
		this.is_have_new = is_have_new;
		notifyPropertyChanged(BR.is_have_new);
	}

	public int getLast_chapter_index() {
		return this.last_chapter_index;
	}

	public void setLast_chapter_index(int last_chapter_index) {
		this.last_chapter_index = last_chapter_index;
	}

	public boolean getRefreshed() {
		return this.refreshed;
	}

	public void setRefreshed(boolean refreshed) {
		this.refreshed = refreshed;
	}

	public boolean getIsShowTrash() {
		return this.isShowTrash;
	}

	public void setIsShowTrash(boolean isShowTrash) {
		this.isShowTrash = isShowTrash;
		notifyPropertyChanged(BR.isShowTrash);
	}

	public Date getAdd_date() {
		return this.add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int type;

	public Novel() {

	}

	@Generated(hash = 1851106351)
	public Novel(long id, String author_name, long dateModified, String description,
									String genre, String genre_index, String image, String current_url,
									String name, String newestChapter_headline, String newestChapter_url,
									long totalClick, String trialStatus, String updateStatus, String url,
									long wordCount, long read_chapter_count, int all_chapter_count,
									boolean is_have_new, int last_chapter_index, Date add_date, int type) {
					this.id = id;
					this.author_name = author_name;
					this.dateModified = dateModified;
					this.description = description;
					this.genre = genre;
					this.genre_index = genre_index;
					this.image = image;
					this.current_url = current_url;
					this.name = name;
					this.newestChapter_headline = newestChapter_headline;
					this.newestChapter_url = newestChapter_url;
					this.totalClick = totalClick;
					this.trialStatus = trialStatus;
					this.updateStatus = updateStatus;
					this.url = url;
					this.wordCount = wordCount;
					this.read_chapter_count = read_chapter_count;
					this.all_chapter_count = all_chapter_count;
					this.is_have_new = is_have_new;
					this.last_chapter_index = last_chapter_index;
					this.add_date = add_date;
					this.type = type;
	}
}