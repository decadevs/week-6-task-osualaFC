package com.example.weeksix

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.ComponentNameMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.core.AllOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/** package name **/
private val PACKAGE_NAME = "com.example.weeksix"

class IntentTest {


    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)



    /** TEST IF INTENT DATA IS MOVED FROM MAIN_ACTIVITY TO PROFILE_ACTIVITY**/
    @Test
    fun test_intent_from_Main_to_Profile(){

        /** instance of Test Function class**/
        var testFunc = TestFunc()


        /**instance of intent class **/
        val data = Intent()

        /** fill the form**/
        testFunc.fill_form()

        /** click the button **/
        onView(withId(R.id.signInBtn)).perform(ViewActions.click())

        /**Build the result to return when the activity is launched**/
        data.putExtra("NAME_KEY", testFunc.name)
        data.putExtra("PHONE_KEY", testFunc.phone)
        data.putExtra("EMAIL_KEY", testFunc.email)
        data.putExtra("GENDER_KEY", testFunc.gender)

        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, data)

        /** setUp result stubbing**/
        intending(toPackage(PACKAGE_NAME)).respondWith(result)

        /**Assert result **/
        onView(withId(R.id.nameValue)).check(matches(withText(testFunc.name)))
        onView(withId(R.id.phoneValue)).check(matches(withText(testFunc.phone)))
        onView(withId(R.id.emailValue)).check(matches(withText(testFunc.email)))
        onView(withId(R.id.genderValue)).check(matches(withText(testFunc.gender)))
    }


}