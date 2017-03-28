package com.mobileappsandroid.training.retrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android on 3/28/2017.
 */

public interface MACRetroI {

    @GET("examples")
    Call <List<Example>> getAllExamples();

    @GET("posts")
    Call<List<Example>> getExamplesById(@Query("userId") Integer id);

}
