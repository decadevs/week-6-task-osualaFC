package com.example.weeksix

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*


/** form parameters **/


open class MainActivity : AppCompatActivity() {


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
//            if( !validateFullName() || !validateEmail() || !validateGender() || !validatePhoneNumber()){
//                return@setOnClickListener
//            }
//            else{
//                Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show()
//            }

            moveToProfile()
        }
    }





    /**validate phone number**/
    fun validatePhoneNumber(): Boolean {
        val naijaPhone = Regex("""^(\+?234|0)[897][01]\d{8}${'$'}""")
        val num = phoneNum.editText?.text.toString().trim()

        return if (num.isEmpty()) {
            phoneNum.error = "Field can not be empty"
            false
        }
        else if(!num.matches(naijaPhone)){
            phoneNum.error = "Enter a valid phone number"
            return false
        }else{
            phoneNum.error = null
            phoneNum.isErrorEnabled = false
            true
        }

    }

    /** move to profile activity function**/
    private fun moveToProfile(){

        /** initialize values **/
        phoneText = phoneNum.editText?.text.toString().trim()
        nameText = fullName.editText?.text.toString().trim()
        emailText = Email.editText?.text.toString().trim()
        genderText = sex.editText?.text.toString().trim()


        intent = Intent(this, ProfileActivity::class.java )
        intent.putExtra("name_key", nameText)
        intent.putExtra("phone_key", phoneText)
        intent.putExtra("email_key", emailText)
        intent.putExtra("gender_key", genderText)




        startActivity(intent)
    }

    /**validate full name**/
    private fun validateFullName(): Boolean {
        val name = fullName.editText?.text.toString().trim()
        return if (name.isEmpty()) {
            fullName.error = "Field can not be empty"
            false
        } else {
            fullName.error = null
            fullName.isErrorEnabled = false
            true
        }
    }

    /** validate email **/
    private  fun validateEmail(): Boolean {
        val email = Email.editText?.text.toString().trim()
        val emailPattern = Regex("""^(\w+\.?(\w+)?@([a-zA-Z_]+\.){1,2}[a-zA-Z]{2,6})${'$'}""")

        return if (email.isEmpty()) {
            Email.error  = "Field can not be empty"
            false
        }
        else if(!email.matches(emailPattern)){
            Email.error = "Enter a valid email address"
            return false
        }
         else {
            Email.error = null
            Email.isErrorEnabled = false
            true
        }
    }
    /**validate gender**/
    private fun validateGender(): Boolean {
        val gender = sex.editText?.text.toString().trim()
        return if (gender.isEmpty()) {
            sex.error = "Field can not be empty"
            false
        } else {
            sex.error = null
            sex.isErrorEnabled = false
            true
        }
    }
}