package com.example.weeksix


import kotlinx.android.synthetic.main.activity_main.*

class Validation : MainActivity() {

    /**validate phone number**/
    fun validatePhoneNumber(num: String): Boolean {
        val naijaPhone = Regex("""^(\+?234|0)[897][01]\d{8}${'$'}""")

        return if (num.isEmpty()) {
            phoneNum.error = "Field can not be empty"
            false
        } else if (!num.matches(naijaPhone)) {
            phoneNum.error = "Enter a valid phone number"
            return false
        } else {
     phoneNum.error = null
      phoneNum.isErrorEnabled = false
            true
        }

    }
}