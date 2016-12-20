package com.code1912.novelgo.db;

import android.database.Cursor;

import com.code1912.novelgo.application.AppContext;
import com.code1912.novelgo.bean.ChapterContent;
import com.code1912.novelgo.bean.ChapterContentDao;
import com.code1912.novelgo.bean.ChapterInfo;
import com.code1912.novelgo.bean.ChapterInfoDao;
import com.code1912.novelgo.bean.Novel;
import com.code1912.novelgo.bean.NovelDao;
import com.code1912.novelgo.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class NovelDataAccess {
	static final NovelDataAccess novelDataAccess = new NovelDataAccess();

	public NovelDataAccess getInstance() {
		return novelDataAccess;
	}

	private NovelDao getNovelDao() {
		return AppContext.getDaoSession().getNovelDao();
	}

	private ChapterInfoDao getChapterInfoDao() {
		return AppContext.getDaoSession().getChapterInfoDao();
	}

	private ChapterContentDao getChapterContentDao() {
		return AppContext.getDaoSession().getChapterContentDao();
	}

	public List<Novel> getAllNovels() {
		return getNovelDao().loadAll();
	}

	public void addNovel(Novel novel) {
		novel.setAdd_date(Util.getCurrentDate());
		getNovelDao().save(novel);
	}

	public void updateNovelReadChapterCount(long novelId, int readCount) {
		Novel info = getNovelDao().load(novelId);
		info.setRead_chapter_count(readCount);
		getNovelDao().save(info);
	}

	public void updateNovelIsHaveNew(long novelId, boolean isHaveNew) {
		Novel info = getNovelDao().load(novelId);
		info.setIs_have_new(isHaveNew);
		getNovelDao().save(info);
	}

	public void DeleteNovel(long novelId) {
		getNovelDao().deleteByKey(novelId);
		AppContext.getDaoSession().getDatabase().execSQL(String.format("delete  from  Chapter_Info where novelId=%d  ", novelId), null);

	}

	public List<ChapterInfo> getAllChapters(long novelId, int type) {
		List<ChapterInfo> list = new ArrayList<>();
		list = getChapterInfoDao().queryRaw(String.format(" novelId=? and typ=?", novelId, type), String.valueOf(novelId), String.valueOf(type));
		return list;
	}

	public void updateChapterPosition(long chapterId, int position) {
		ChapterInfo info = getChapterInfoDao().load(chapterId);
		info.setPosition(position);
		getChapterInfoDao().save(info);
	}

	public String getChapterContent(long chapterId) {
		ChapterContent info = getChapterContentDao().load(chapterId);
		return info == null ? "" : info.getContent();
	}

	public void updateContent(long chapterId, String content) {
		ChapterContent info = getChapterContentDao().load(chapterId);
		if (info == null) {
			info = new ChapterContent(chapterId, content);
		}
		info.setContent(content);
		getChapterContentDao().save(info);
	}

	public void addChapterList(long novelId, List<ChapterInfo> list) {
		for (ChapterInfo chapterInfo : list) {
			chapterInfo.setNovel_id(novelId);
			chapterInfo.setAdd_date(Util.getCurrentDate());
		}
		getChapterInfoDao().saveInTx(list);
	}
}
