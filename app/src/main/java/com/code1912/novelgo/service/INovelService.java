package com.code1912.novelgo.service;

import com.code1912.novelgo.bean.ChapterInfo;
import com.code1912.novelgo.bean.CommonResponse;
import com.code1912.novelgo.bean.Novel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Code1912 on 2016/12/16.
 */

public interface INovelService {
	@GET("search")
	Observable<CommonResponse<Novel>> search(@Query("keyword") String keyword, @Query("pageIndex") int  pageIndex,@Query("type") int type);

	@GET("chapterList")
	Observable<CommonResponse<ChapterInfo>> chapterList(@Query("url") String url, @Query("type") int type);

	@GET("chapterInfo")
	Observable<CommonResponse<ChapterInfo>> chapterInfo(@Query("url") String url, @Query("type") int type);
}
