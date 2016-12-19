package com.code1912.novelgo.db;

import com.code1912.novelgo.bean.ChapterInfo;
import com.code1912.novelgo.bean.Novel;
import com.code1912.novelgo.util.Util;

import java.util.List;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class NovelDataAccess {
	static final NovelDataAccess novelDataAccess = new NovelDataAccess();

	public NovelDataAccess getInstance() {
		return novelDataAccess;
	}

	/*public List<Novel> getAllNovels() {
		return Novel.listAll(Novel.class);
	}

	public void addNovel(Novel novel) {
		novel.add_date=Util.getCurrentDate();
		novel.save();
	}

	public void updateNovelReadChapterCount(long novelId,int readCount) {
		Novel info= 	Novel.findById(Novel.class,novelId);
		info.read_chapter_count=readCount;
		info.save();
	}

	public void updateNovelIsHaveNew(long novelId,boolean isHaveNew) {
		Novel info= 	Novel.findById(Novel.class,novelId);
		info.is_have_new=isHaveNew;
		info.save();
	}

	public  void DeleteNovel(long novelId) {
		Novel info = Novel.findById(Novel.class, novelId);
		info.delete();
		List<ChapterInfo> list = ChapterInfo.findWithQuery(ChapterInfo.class,
			String.format("select id from  Chapter_Info where novelId=%d     order by  chapterIndex asc ", novelId));
		if (list != null) {
			for (ChapterInfo chapterInfo : list) {
				chapterInfo.delete();
			}
		}
	}

	public List<ChapterInfo> getAllChapters(long novelId,int type) {
		List<ChapterInfo> list = ChapterInfo.findWithQuery(ChapterInfo.class,
			String.format("select id, title,url,novelId,addDate,isReaded,position,chapterIndex,isDownloaded,'' as content,type from  Chapter_Info where novelId=%d and type=%d order by  chapterIndex asc ", novelId, type));
		return list;
	}

	public  void updateChapterPosition(long chapterId,int position){
		ChapterInfo info= 	ChapterInfo.findById(ChapterInfo.class,chapterId);
		info.position=position;
		info.save();
	}

	public String getChapterContent(long chapterId){
		ChapterInfo info= 	ChapterInfo.findById(ChapterInfo.class,chapterId);
		return  info==null?"":info.content;
	}

	public  void  addChapterList(long novelId,List<ChapterInfo> list){
		for (ChapterInfo chapterInfo : list) {
			chapterInfo.novel_id=novelId;
			chapterInfo.add_date= Util.getCurrentDate();
		}
		ChapterInfo.saveInTx(list);
	}*/
}
