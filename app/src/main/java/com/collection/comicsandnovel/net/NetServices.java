package com.collection.comicsandnovel.net;


import com.collection.comicsandnovel.bean.BaseEntity;
import com.collection.comicsandnovel.bean.Login;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface NetServices {

    @POST("/login/submit")
    Observable<BaseEntity<Login>> login(@Query("phone") String phone,
                                        @Query("password") String password);

    @POST("/api/index/get_code")
    Observable<BaseEntity> getVertical(@Query("mobile") String phone);
}
