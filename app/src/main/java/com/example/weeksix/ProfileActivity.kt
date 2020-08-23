package com.example.weeksix


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {


    /** instantiate values**/
    lateinit var  profileName:String
    lateinit var  profilePhoneNumber:String
    lateinit var  profileEmail:String
    lateinit var profileGender:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)




        /** get values from mainActivity **/
        profileName = intent.getStringExtra("name_key").toString()
        profilePhoneNumber = intent.getStringExtra("phone_key").toString()
        profileEmail = intent.getStringExtra("email_key").toString()
        profileGender = intent.getStringExtra("gender_key").toString()

        /** set TextViews text values**/
        nameValue.text = profileName
        phoneValue.text = profilePhoneNumber
        emailValue.text = profileEmail
        genderValue.text = profileGender
    }
}