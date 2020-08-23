package com.example.weeksix

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**custom matcher for textInputLayout hint**/

fun textInputLayoutwithItemHint(matcherText: String): Matcher<View?>? {
    return object : BoundedMatcher<View?, TextInputLayout>(TextInputLayout::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("with item hint: $matcherText")
        }

        override fun matchesSafely(editTextField: TextInputLayout): Boolean {
            return matcherText.equals(editTextField.hint.toString(), ignoreCase = true)
        }
    }
}

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    /** launch the activity**/
    @get :Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

/** test if MainActivity is in view**/
    @Test
    fun test_visibility_main_activity(){
        /** find the view  and check if the view is displayed**/
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

/** test if MainActivity views are visible**/
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


    /** test if texts and hints are visible **/
    @Test
    fun test_visibility_main_activity_texts_hints(){

        /** test if title text is visible**/
        onView(withId(R.id.title)).check(matches(withText(R.string.create_account)))

        /** test if fullName hint is visible**/
        onView(withId(R.id.fullName)).check(matches(textInputLayoutwithItemHint("full name")))

        /** test if phoneNumber hint is visible**/
        onView(withId(R.id.phoneNum)).check(matches(textInputLayoutwithItemHint("phone number")))

        /** test if email hint is visible**/
        onView(withId(R.id.Email)).check(matches(textInputLayoutwithItemHint("email")))

        /** test if gender hint is visible**/
        onView(withId(R.id.sex)).check(matches(textInputLayoutwithItemHint("gender")))
        /** test if button text is visible**/
        onView(withId(R.id.signInBtn)).check(matches(withText(R.string.sign_in)))
    }

    /** test for navigation to ProfileActivity **/

    @Test
    fun test_navigate_to_profile_activity(){
       // scenario.waitForActivityToBecomeAnyOf(State.STOPPED, State.DESTROYED);

        onView(withId(R.id.text_fullName)).perform(replaceText("fredrick"))
        onView(withId(R.id.text_phoneNum)).perform(replaceText("07037625007"))
        onView(withId(R.id.text_email)).perform(replaceText("fredrick.osuala@decagon.dev"))
        onView(withId(R.id.dropdown)).perform(replaceText("Male"))

        /** find the view and perform a click assertion **/
        onView(withId(R.id.signInBtn)).perform(click())
        /** get the profile activity and check if it is displayed**/
        onView(withId(R.id.profileActivity)).check(matches(isDisplayed()))
    }




}





//val activityScenerio = ActivityScenario.launch(MainActivity::class.java)

