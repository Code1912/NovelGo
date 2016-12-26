package com.code1912.novelgo.biz;
import com.code1912.novelgo.bean.ChapterContent;
import com.code1912.novelgo.bean.ChapterInfo;
import com.code1912.novelgo.bean.Novel;
import com.code1912.novelgo.util.Util;
import com.orm.SugarRecord;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Code1912 on 2016/12/18.
 */

public class NovelBiz {
	static final NovelBiz biz = new NovelBiz();

	public static NovelBiz getInstance() {
		return biz;
	}

	public List<Novel> getAllNovels() {
		return SugarRecord.listAll(Novel.class);
	}

	public void addNovel(Novel novel) {
		novel.setAdd_date(Util.getCurrentDate());
		SugarRecord.save(novel);
	}

	public Novel getNovel(long id) {
		return SugarRecord.findById(Novel.class,id);
	}

	public void updateNovelReadChapterCount(long novelId, int readCount) {
		Novel info = getNovel(novelId);
		info.setRead_chapter_count(readCount);
		SugarRecord.save(info);
	}

	public void updateNovelIsHaveNew(long novelId, boolean isHaveNew) {
		Novel info = getNovel(novelId);
		info.setHasNew(isHaveNew);
		SugarRecord.save(info);
	}

	public void deleteNovel(long novelId) {
		Novel novel = getNovel(novelId);
		SugarRecord.delete(novel);
		List<ChapterInfo> list = getAllChapters(novel.getId(), novel.getType());
		SugarRecord.deleteInTx(list);
		for (ChapterInfo info : list) {
			SugarRecord.deleteAll(ChapterContent.class,String.format("  chapterId=%d",info.getId()));
		}

	}

	public List<ChapterInfo> getAllChapters(long novelId, int type) {
		List<ChapterInfo> list = new ArrayList<>();
		list=SugarRecord.find(ChapterInfo.class,"    novelId=? and type=?",new String[]{String.valueOf(novelId),String.valueOf(type)},"","chapterIndex asc",null);
		return list;
	}

	public void updateChapterPosition(long chapterId, int position) {
		ChapterInfo info = SugarRecord.findById(ChapterInfo.class,chapterId);
		info.setPosition(position);
		SugarRecord.save(info);
	}

	public String getChapterContent(long chapterId) {
		ChapterContent info = getContentByChapterId(chapterId);
		return info == null ? "" : info.getContent();
	}

	private  ChapterContent getContentByChapterId(long chapterId){
		List<ChapterContent> list=SugarRecord.find(ChapterContent.class,String.format("chapterId=%d",chapterId));
		return  list==null||list.size()==0?null:list.get(0);
	}
	public void updateContent(long chapterId, String content) {
		ChapterContent info =  getContentByChapterId(chapterId);
		if (info == null) {
			info = new ChapterContent(chapterId, content);
		}
		info.setContent(content);
		SugarRecord.save(info);
	}

	public void addChapterList(long novelId, List<ChapterInfo> list) {
		for (ChapterInfo chapterInfo : list) {
			chapterInfo.setNovel_id(novelId);
			chapterInfo.setAdd_date(Util.getCurrentDate());
		}
		SugarRecord.saveInTx(list);
	}
}
