package com.example.weeksix




class Validation  {

    /**validate phone number**/
    fun validatePhoneNumber(num: String): Boolean {
        val naijaPhone = Regex("""^(\+?234|0)[897][01]\d{8}${'$'}""")

        return if (num.isEmpty()) {
            false
        }
        else if(!num.matches(naijaPhone)){
            return false
        }else{
            true
        }

    }

    /**validate full name**/
    fun validateFullName(str:String): Boolean {
        return str.isNotEmpty()
    }

    /** validate email **/
    fun validateEmail(email:String): Boolean {

        val emailPattern = Regex("""^(\w+\.?(\w+)?@([a-zA-Z_]+\.){1,2}[a-zA-Z]{2,6})${'$'}""")

        return if (email.isEmpty()) {
            false
        }
        else if(!email.matches(emailPattern)){
            return false
        }
        else {
            true
        }
    }

    /**validate gender**/
    fun validateGender(gender: String): Boolean {

        return gender.isNotEmpty()
    }




}