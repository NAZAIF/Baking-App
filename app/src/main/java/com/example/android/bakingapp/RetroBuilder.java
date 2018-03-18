package com.example.android.bakingapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nazaif on 17/3/18.
 */

public final class RetroBuilder {
    static RecipeInterface IRecipe;
    public static RecipeInterface Retrieve() {
        Gson gson = new GsonBuilder().create();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        IRecipe = new Retrofit.Builder()
                .baseUrl("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(builder.build())
                .build().create(RecipeInterface.class);

        return IRecipe;
    }




}
