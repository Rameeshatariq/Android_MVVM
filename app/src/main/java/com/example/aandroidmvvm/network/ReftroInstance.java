package com.example.aandroidmvvm.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReftroInstance {
    public static String BASE_URL= "https://velmm.com/apis/";//vollery_array.json;
    private static Retrofit retrofit;
    public static  Retrofit getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
