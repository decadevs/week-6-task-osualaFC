package com.example.weeksix

import org.junit.Test

import org.junit.Assert.*

class ValidationTest {
private val test = Validation()
  /** validatePhoneNum tests**/
  @Test
    fun empty_input(){
      assertEquals(test.validatePhoneNumber(""), false)
  }
    @Test
    fun wrong_input1(){
        assertEquals(test.validatePhoneNumber("0908768765"), false)
    }
    @Test
    fun wrong_input2(){
        assertEquals(test.validatePhoneNumber("908768765"), false)
    }
    @Test
    fun wrong_input3(){
        assertEquals(test.validatePhoneNumber("234803453234"), false)
    }
    @Test
    fun wrong_input4(){
        assertEquals(test.validatePhoneNumber("06033316404"), false)
    }
    @Test
    fun wrong_input5(){
        assertEquals(test.validatePhoneNumber("+243908768765"), false)
    }
    @Test
    fun wrong_input6(){
        assertEquals(test.validatePhoneNumber("0810098736"), false)
    }
    @Test
    fun wrong_input7(){
        assertEquals(test.validatePhoneNumber("03134567878"), false)
    }
    @Test
    fun naija_input1(){
        assertEquals(test.validatePhoneNumber("09087687654"), true)
    }
    @Test
    fun naija_input2(){
        assertEquals(test.validatePhoneNumber("08087623454"), true)
    }
    @Test
    fun naija_input3(){
        assertEquals(test.validatePhoneNumber("+2347037625007"), true)
    }
    @Test
    fun naija_input4(){
        assertEquals(test.validatePhoneNumber("2348028627146"), true)
    }
    @Test
    fun naija_input5(){
        assertEquals(test.validatePhoneNumber("08139893874"), true)
    }

    /** validateEmail test**/
    @Test
    fun wrong_email1(){
        assertEquals(test.validateEmail("fred@gmail"), false)
    }
    @Test
    fun wrong_email2(){
        assertEquals(test.validateEmail("fred.com"), false)
    }
    @Test
    fun wrong_email3(){
        assertEquals(test.validateEmail("fred@gmail..com"), false)
    }
    @Test
    fun wrong_email4(){
        assertEquals(test.validateEmail("fred&gmail.com"), false)
    }
    @Test
    fun wrong_email5(){
        assertEquals(test.validateEmail("fredyahoo@com"), false)
    }
    @Test
    fun correct_email1(){
        assertEquals(test.validateEmail("fred@gmail.com"), true)
    }
    @Test
    fun correct_email2(){
        assertEquals(test.validateEmail("fred.osuala@gmail.com"), true)
    }
    @Test
    fun correct_email3(){
        assertEquals(test.validateEmail("fred@gmail.co.uk"), true)
    }
    @Test
    fun correct_email4(){
        assertEquals(test.validateEmail("fredrick.osuala@decagon.dev"), true)
    }
    @Test
    fun correct_email5(){
        assertEquals(test.validateEmail("fred@yahoo.com"), true)
    }

    /** validateName test**/
    @Test
    fun empty_name(){
        assertEquals(test.validateFullName(""), false)
    }
    @Test
    fun filled_name(){
        assertEquals(test.validateFullName("chibuzor"), true)
    }

    /** validateGender test**/
    @Test
    fun empty(){
        assertEquals(test.validateGender(""), false)
    }
    @Test
    fun filed(){
        assertEquals(test.validateGender("male"), true)
    }
}

