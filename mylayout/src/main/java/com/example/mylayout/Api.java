package com.example.mylayout;


import android.database.Observable;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * author : ZhiG
 * e-mail : 1120121044@163.com
 * date   : 2019/9/1616:49
 * desc   :
 * package: Myp:
 */
public interface Api {
    String url = "http://test.scaiwl.top/analysis/macthpred/";

    @FormUrlEncoded
    @POST("matchPredList?page=&pageSize=&time=&status=")
    Observable<List<Bean>> getData(@Field("page") String page, @Field("pageSize") int pagesize, @Field("time") String time, @Field("status") int status);
}
