package com.example.user.charlesschwabchallenge.model.data.remote;

import com.example.user.charlesschwabchallenge.model.pizza.QueryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteService {

//    @GET("v1/public/yql?q=select * from local.search where zip='30082' and query='pizza'&format=json&diagnostics=true")
    @GET("v1/public/yql")
    Observable<QueryResponse> getPizzaList(@Query("q") String query,
                                           @Query("format") String format,
                                           @Query("diagnostics") String diagnostics);

}
