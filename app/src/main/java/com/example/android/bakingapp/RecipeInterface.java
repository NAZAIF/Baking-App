package com.example.android.bakingapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nazaif on 17/3/18.
 */

public interface RecipeInterface {
    @GET("baking.json")
    Call<ArrayList<Recipes>> getRecipe();
}
