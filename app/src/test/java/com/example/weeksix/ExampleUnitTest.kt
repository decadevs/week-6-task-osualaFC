package com.example.weeksix

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val mainActivity = MainActivity()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
@Test
    fun inValidNumber(){
    assertTrue(mainActivity.validatePhoneNumber("088837272762"))
}

}