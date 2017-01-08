package com.code1912.novelgo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;
import com.code1912.novelgo.util.Util;
import com.orm.dsl.Ignore;
import com.orm.dsl.Table;
import java.util.Date;

/**
 * Created by Code1912 on 2016/12/18.
 */

@Table
public class Novel extends BaseObservable {
	private long id;
	@Bindable
	@Ignore
	private String lastEditDate;
	private String author_name;
	private long dateModified=0L;
	@Bindable
	private String description="";
	private String genre;
	private String genre_index;
	@Bindable
	private String image;
	private String current_url;
	@Bindable
	private String name = null;
	private String newestChapter_headline;
	private String newestChapter_url;
	private long totalClick=0L;
	private String trialStatus;
	private String updateStatus;
	private String url;
	private long wordCount=0L;
	@Bindable
	private int read_chapter_count = 0;
	@Bindable
	private int all_chapter_count = 0;
	@Bindable
	private boolean hasNew = false;
	private int last_chapter_index=0;
	@Ignore
	private boolean refreshed = false;
	@Bindable
	@Ignore
	private boolean showTrash = false;
	private Date add_date;
	private int type=1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public long getDateModified() {
		return dateModified;
	}

	public void setDateModified(long dateModified) {
		this.dateModified = dateModified;
		if(this.dateModified>0){
			this.setLastEditDate( Util.getStrTime(this.dateModified,"yyyy-MM-dd HH:MM:ss"));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		notifyPropertyChanged(BR.description);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre_index() {
		return genre_index;
	}

	public void setGenre_index(String genre_index) {
		this.genre_index = genre_index;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCurrent_url() {
		return current_url;
	}

	public void setCurrent_url(String current_url) {
		this.current_url = current_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyPropertyChanged(BR.name);
	}

	public String getNewestChapter_headline() {
		return newestChapter_headline;
	}

	public void setNewestChapter_headline(String newestChapter_headline) {
		this.newestChapter_headline = newestChapter_headline;
	}

	public String getNewestChapter_url() {
		return newestChapter_url;
	}

	public void setNewestChapter_url(String newestChapter_url) {
		this.newestChapter_url = newestChapter_url;
	}

	public long getTotalClick() {
		return totalClick;
	}

	public void setTotalClick(long totalClick) {
		this.totalClick = totalClick;
	}

	public String getTrialStatus() {
		return trialStatus;
	}

	public void setTrialStatus(String trialStatus) {
		this.trialStatus = trialStatus;
	}

	public String getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getWordCount() {
		return wordCount;
	}

	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}

	public int getRead_chapter_count() {
		return read_chapter_count;
	}

	public void setRead_chapter_count(int read_chapter_count) {
		this.read_chapter_count = read_chapter_count;
		notifyPropertyChanged(BR.read_chapter_count);
	}

	public int getAll_chapter_count() {
		return all_chapter_count;
	}

	public void setAll_chapter_count(int all_chapter_count) {
		this.all_chapter_count = all_chapter_count;
		notifyPropertyChanged(BR.all_chapter_count);
	}

	public boolean getHasNew() {
		return hasNew;
	}

	public void setHasNew(boolean hasNew) {
		this.hasNew = hasNew;
		notifyPropertyChanged(BR.hasNew);
	}

	public int getLast_chapter_index() {
		return last_chapter_index;
	}

	public void setLast_chapter_index(int last_chapter_index) {
		this.last_chapter_index = last_chapter_index;
	}

	public boolean isRefreshed() {
		return refreshed;
	}

	public void setRefreshed(boolean refreshed) {
		this.refreshed = refreshed;
	}

	public boolean getShowTrash() {
		return showTrash;
	}

	public void setShowTrash(boolean isShowTrash) {
		this.showTrash = isShowTrash;
		notifyPropertyChanged(BR.showTrash);
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
		notifyPropertyChanged(BR.lastEditDate);
	}
}