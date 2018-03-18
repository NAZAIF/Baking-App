package com.example.android.bakingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.android.bakingapp.R;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity implements RecipeAdapter.ListItemClickListener {

    static String ALL_RECIPES = "All_Recipes";
    static String SELECTED_RECIPES = "Selected_Recipes";
    static String SELECTED_STEPS = "Selected_Steps";
    static String SELECTED_INDEX = "Selected_Index";

    @Nullable
    private BakingIdlingResource idlingResource;

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (idlingResource == null) {
            idlingResource = new BakingIdlingResource();
        }
        return idlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("Baking Time");
        getIdlingResource();
    }

    @Override
    public void onListItemClick(Recipes index) {
        Bundle selectedRecipeBundle = new Bundle();
        ArrayList<Recipes> selectedRecipe = new ArrayList<>();
        selectedRecipe.add(index);
        selectedRecipeBundle.putParcelableArrayList(SELECTED_RECIPES, selectedRecipe);
        final Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtras(selectedRecipeBundle);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
