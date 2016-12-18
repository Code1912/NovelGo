package com.code1912.novelgo.service;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.code1912.novelgo.bean.ChapterInfo;
import com.code1912.novelgo.bean.CommonResponse;
import com.code1912.novelgo.bean.Novel;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.http.Query;

/**
 * Created by Code1912 on 2016/12/15.
 */

public class NovelService implements  INovelService {

	static final String API_HOST = "http://192.168.1.107:3000/";
	Retrofit retrofit;
	INovelService service;

	NovelService() {
		retrofit = new Retrofit
			.Builder().
			addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.addConverterFactory(new NovelConverterFactory())
			.addConverterFactory(new ChapterInfoConverterFactory())
			.baseUrl(API_HOST)
			.client(genericClient())
			.build();

		service = retrofit.create(INovelService.class);

	}

	@Override
	public Observable<CommonResponse<Novel>> search(@Query("keyword") String keyword,@Query("pageIndex") int  pageIndex, @Query("type") int type) {
		return service.search(keyword, pageIndex, type);
	}

	@Override
	public Observable<CommonResponse<ChapterInfo>> chapterList(@Query("url") String url, @Query("type") int type) {
		return service.chapterList(url, type);
	}

	@Override
	public Observable<CommonResponse<ChapterInfo>> chapterInfo(@Query("url") String url, @Query("type") int type) {
		return service.chapterInfo(url, type);
	}

	private static OkHttpClient genericClient() {
		OkHttpClient httpClient = new OkHttpClient();
		httpClient.interceptors().add(chain -> {
			Request request = chain.request();
			MediaType mediaType = request.body().contentType();
			try {
				Field field = mediaType.getClass().getDeclaredField("mediaType");
				field.setAccessible(true);
				field.set(mediaType, "application/json");
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return chain.proceed(request);
		});
		return httpClient;
	}

	static class NovelConverterFactory extends Converter.Factory {
		@Override
		public Converter<ResponseBody, CommonResponse<Novel>> responseBodyConverter(Type type, java.lang.annotation.Annotation[] annotations,
											    Retrofit retrofit) {
			return new NovelConverter();
		}
	}

	static class ChapterInfoConverterFactory extends Converter.Factory {
		@Override
		public Converter<ResponseBody, CommonResponse<ChapterInfo>> responseBodyConverter(Type type, java.lang.annotation.Annotation[] annotations,
												  Retrofit retrofit) {
			return new ChapterInfoConverter();
		}
	}

	static class NovelConverter implements Converter<ResponseBody, CommonResponse<Novel>> {
		@Override
		public CommonResponse<Novel> convert(ResponseBody value) throws IOException {
			CommonResponse<Novel> result;
			try {
				String str = value.string();
				result = JSON.parseObject(str, new TypeReference<CommonResponse<Novel>>() {
				});
			} catch (IOException ex) {
				result = new CommonResponse<>();
				result.success = false;
			}

			return result;
		}
	}

	static class ChapterInfoConverter implements Converter<ResponseBody, CommonResponse<ChapterInfo>> {
		@Override
		public CommonResponse<ChapterInfo> convert(ResponseBody value) throws IOException {
			CommonResponse<ChapterInfo> result;
			try {
				String str = value.string();
				result = JSON.parseObject(str, new TypeReference<CommonResponse<ChapterInfo>>() {
				});

			} catch (IOException ex) {
				result = new CommonResponse<>();
				result.success = false;
			}
			return result;
		}
	}
}