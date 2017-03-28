package com.mobileappsandroid.training.retrofit1;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 3/28/2017.
 */

public class RContr implements Callback<List<Example>> {

    static final String BASE_URL = "http://jsonplaceholder.typicode.com";
    MainActivity mMA;

    public void setA(MainActivity ma)
    {
        mMA = ma;
    }


    public void start(int i)
    {
        Gson gs = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gs))
                .build();

        MACRetroI myAPI = retrofit.create(MACRetroI.class);

        if (i > 0)
        {
            Call<List<Example>> call = myAPI.getExamplesById(i);

            call.enqueue(this);
        }
        else
        {
            Call<List<Example>> call = myAPI.getAllExamples();

            call.enqueue(this);
        }




    }

    @Override
    public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

        if (response.isSuccessful())
        {
            List<Example> myExamples = response.body();
            StringBuilder sb = new StringBuilder();

            for (Example e: myExamples)
            {
                String s = e.getId() + "\n" +  e.getTitle() + "\n" + e.getBody() + "\n\n";
                Log.d("MAC_Tag", s);
                sb.append(s);
            }

            mMA.write2TV(sb.toString());

        }
        else
        {
            Log.d("MAC_TAG", ":(");
        }

    }

    @Override
    public void onFailure(Call<List<Example>> call, Throwable t) {

    }
}
