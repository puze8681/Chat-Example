package com.example.parktaejun.chattingexample.Server;

import com.example.parktaejun.chattingexample.Datas.IDCard;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by parktaejun on 2017. 2. 12..
 */

public interface IDCardService {
    @Headers("Content-Type : application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("/")
    Call<IDCard> login(@Field("id") String id, @Field("pass") String pass);
}
