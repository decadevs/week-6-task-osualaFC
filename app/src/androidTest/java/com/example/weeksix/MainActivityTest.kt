package com.example.weeksix


import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith





@RunWith(AndroidJUnit4ClassRunner::class)

class MainActivityTest{

    /** launch the activity**/
    @get :Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


/** TEST IF MAIN_ACTIVITY IS IN VIEW**/
    @Test
    fun test_visibility_main_activity(){
        /** find the view  and check if the view is displayed**/
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

/** TEST IF BACKGROUND IS DISPLAYED**/
    @Test
    fun visibility_main_background(){
        onView(allOf(withId(R.id.main), hasBackground(R.drawable.background), isDisplayed()));
    }

/** TEST IF MAIN_ACTIVITY VIEWS ARE VISIBLE**/
    @Test
    fun test_visibility_main_activity_views(){

        /** test if title is in view**/
        onView(withId(R.id.title)).check(matches(isDisplayed()))

        /** test if fullName editText is in view**/
        onView(withId(R.id.fullName)).check(matches(isDisplayed()))

        /** test if phoneNum editText is in view**/
        onView(withId(R.id.phoneNum)).check(matches(isDisplayed()))

        /** test if email editText is in view**/
        onView(withId(R.id.Email)).check(matches(isDisplayed()))

        /** test if gender editText is in view**/
        onView(withId(R.id.sex)).check(matches(isDisplayed()))

        /** test if signIn button is in view**/
        onView(withId(R.id.signInBtn)).check(matches(isDisplayed()))
    }


    /** TEST IF TEXTS AND HINTS AR VISIBLE **/
    @Test
    fun test_visibility_main_activity_texts_hints(){

        /** instance of Test Function class**/
        var testFunc = TestFunc()

        /** test if title text is visible**/
        onView(withId(R.id.title)).check(matches(withText(R.string.create_account)))

        /** test if fullName hint is visible**/
        onView(withId(R.id.fullName)).check(matches(testFunc.hintMatcher("full name")))

        /** test if phoneNumber hint is visible**/
        onView(withId(R.id.phoneNum)).check(matches(testFunc.hintMatcher("phone number")))

        /** test if email hint is visible**/
        onView(withId(R.id.Email)).check(matches(testFunc.hintMatcher("email")))

        /** test if gender hint is visible**/
        onView(withId(R.id.sex)).check(matches(testFunc.hintMatcher("gender")))
        /** test if button text is visible**/
        onView(withId(R.id.signInBtn)).check(matches(withText(R.string.sign_in)))
    }



    /** TEST FOR NAVIGATION TO PROFILE_ACTIVITY **/

    @Test
    fun test_navigate_to_profile_activity(){

        /** instance of Test Function class**/
        var testFunc = TestFunc()

        /** launch activity**/
        val activityScenario: ActivityScenario<MainActivity> = ActivityScenario.launch(MainActivity::class.java)

        activityScenario.moveToState(Lifecycle.State.RESUMED)

        /** fill form**/
       testFunc.fill_form()

        /** find the view and perform a click assertion **/
        onView(withId(R.id.signInBtn)).perform(click())
        /** get the profile activity and check if it is displayed**/
        onView(withId(R.id.profileActivity)).check(matches(isDisplayed()))

    }

}

// scenario.waitForActivityToBecomeAnyOf(State.STOPPED, State.DESTROYED);

//val activityScenerio = ActivityScenario.launch(MainActivity::class.java)

