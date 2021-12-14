package com.capwaydemo

import java.util.regex.Pattern

object Utils {

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )


    fun validateEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }
    fun validateEmailOrPhone(emailOrPhone: String): Boolean {

        val phone = try {
            emailOrPhone.toLong()
        } catch (e: Exception) {
            0L
        }

        return if (phone > 0 && emailOrPhone.length == 10) {
            true
        } else {
            validateEmail(emailOrPhone)
        }
    }
}
