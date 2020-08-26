package com.example.weeksix

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class TestFunc {
    /**custom matcher for textInputLayout hint**/

    fun hintMatcher(matcherText: String): Matcher<View?>? {
        return object : BoundedMatcher<View?, TextInputLayout>(TextInputLayout::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("with item hint: $matcherText")
            }

            override fun matchesSafely(editTextField: TextInputLayout): Boolean {
                return matcherText.equals(editTextField.hint.toString(), ignoreCase = true)
            }
        }
    }



    /** form input details**/

    val name = "fredrick"
    val phone = "07037625007"
    val email = "fredrick.osuala@decagon.dev"
    val gender = "Male"

    /** this function fills the form during testing**/
    fun fill_form() {
        val name =
            Espresso.onView(ViewMatchers.withId(R.id.text_fullName))
                .perform(ViewActions.replaceText(name))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.text_phoneNum))
            .perform(ViewActions.replaceText(phone))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.text_email))
            .perform(ViewActions.replaceText(email))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.dropdown)).perform(ViewActions.replaceText(gender))
        Espresso.closeSoftKeyboard()
    }

    fun fill_error_form() {
        val name =
            Espresso.onView(ViewMatchers.withId(R.id.text_fullName))
                .perform(ViewActions.replaceText(""))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.text_phoneNum))
            .perform(ViewActions.replaceText(phone))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.text_email))
            .perform(ViewActions.replaceText(email))
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.dropdown)).perform(ViewActions.replaceText(gender))
        Espresso.closeSoftKeyboard()
    }
}