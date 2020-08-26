package com.example.weeksix


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.core.AllOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class ProfileActivityTest {


    /** launch the activity**/
    @get: Rule
    val activityRule = ActivityScenarioRule(ProfileActivity::class.java)


    /** TEST IF PROFILE_ACTIVITY IS IN VIEW**/
    @Test
    fun test_visibility_profile_activity() {
        /** find the view  and check if the view is displayed**/
        onView(ViewMatchers.withId(R.id.profileActivity))
            .check(matches(isDisplayed()))
    }

    /** TEST IF BACKGROUND IS DISPLAYED**/
    @Test
    fun visibility_main_background() {
        onView(AllOf.allOf(ViewMatchers.withId(R.id.profileActivity), ViewMatchers.hasBackground(R.drawable.background), isDisplayed()));
    }

    /**TEST IF PROFILE-ACTIVITY VIEWS ARE VISIBLE**/
    @Test
    fun test_visibility_profile_activity_views() {

        /** test if card view is in view**/
        onView(ViewMatchers.withId(R.id.cardView))
            .check(matches(isDisplayed()))

        /** test if profile image is in view**/
        onView(ViewMatchers.withId(R.id.profile))
            .check(matches(isDisplayed()))

        /** test if name icon is in view**/
        onView(ViewMatchers.withId(R.id.nameImage))
            .check(matches(isDisplayed()))

        /** test if name text is in view**/
        onView(ViewMatchers.withId(R.id.nameValue))
            .check(matches(isDisplayed()))

        /** test if phone icon is in view**/
        onView(ViewMatchers.withId(R.id.phoneImage))
            .check(matches(isDisplayed()))

        /** test if phone text is in view**/
        onView(ViewMatchers.withId(R.id.phoneValue))
            .check(matches(isDisplayed()))

        /** test if email icon is in view**/
        onView(ViewMatchers.withId(R.id.emailImage))
            .check(matches(isDisplayed()))

        /** test if email text is in view**/
        onView(ViewMatchers.withId(R.id.emailValue))
            .check(matches(isDisplayed()))

        /** test if gender icon is in view**/
        onView(ViewMatchers.withId(R.id.genderImage))
            .check(matches(isDisplayed()))

        /** test if gender text is in view**/
        onView(ViewMatchers.withId(R.id.genderValue))
            .check(matches(isDisplayed()))
    }


}