package com.example.weeksix

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*





open class MainActivity : AppCompatActivity() {

    /** instance of validation class **/
    private var validate = Validation()

    /**data**/
    private val gender = arrayOf("Male", "Female")

    /** instantiate values**/
    lateinit var  nameText:String
    lateinit var  phoneText:String
    lateinit var  emailText:String
    lateinit var genderText:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** adapter for drop-down**/
        val adapter = ArrayAdapter<String>(this, R.layout.dropdown_menu_popup_item, gender)
        dropdown.setAdapter(adapter)

        /** button click listener**/
        signInBtn.setOnClickListener {

           if(!validateDetails()){
               return@setOnClickListener
           }else{
               moveToProfile()
           }

        }
    }



    /** validation function **/
    private fun validateDetails():Boolean{

        /** initialize values **/
        phoneText = phoneNum.editText?.text.toString().trim()
        nameText = fullName.editText?.text.toString().trim()
        emailText = Email.editText?.text.toString().trim()
        genderText = sex.editText?.text.toString().trim()

        if(!validate.validateFullName(nameText)){
            fullName.error = "Name cannot be empty"
          return false
        }else if(!validate.validateEmail((emailText))){
            Email.error = "Enter a valid email address"
            return false
        }else if(!validate.validatePhoneNumber((phoneText))){
            phoneNum.error = "Enter a valid phone number"
            return false
        }else if(!validate.validateGender((genderText))){
            sex.error = "Gender cannot be empty"
            return false
        }
        return true
    }


    /** move to profile activity function**/
    private fun moveToProfile(){

        /** initialize values **/
        phoneText = phoneNum.editText?.text.toString().trim()
        nameText = fullName.editText?.text.toString().trim()
        emailText = Email.editText?.text.toString().trim()
        genderText = sex.editText?.text.toString().trim()

        intent = Intent(this, ProfileActivity::class.java )
        intent.putExtra("NAME_KEY", nameText)
        intent.putExtra("PHONE_KEY", phoneText)
        intent.putExtra("EMAIL_KEY", emailText)
        intent.putExtra("GENDER_KEY", genderText)

        startActivity(intent)
    }





}