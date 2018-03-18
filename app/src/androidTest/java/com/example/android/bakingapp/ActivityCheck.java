package com.example.android.bakingapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by nazaif on 17/3/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityCheck {
    @Rule
    public ActivityTestRule<RecipeActivity> mActivityTestRule = new ActivityTestRule<>(RecipeActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void checkText_RecipeActivity() {
        onView(ViewMatchers.withId(R.id.recipe_recycler)).perform(RecyclerViewActions.scrollToPosition(1));
        onView(withText("Brownies")).check(matches(isDisplayed()));
    }

    @Test
    public void checkPlayerViewIsVisible_RecipeDetailActivity1() {
        onView(ViewMatchers.withId(R.id.recipe_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(ViewMatchers.withId(R.id.recipe_detail_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.playerView)).check(matches(isDisplayed()));
    }

}
