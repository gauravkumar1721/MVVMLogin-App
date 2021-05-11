package com.example.finloginmvvm.Model

import android.util.Patterns




class LoginUser(value: String?, value1: String?) {
    private var strEmailAddress: String? = null
    private var strPassword: String? = null
    fun LoginUser(EmailAddress: String, Password: String) {
        strEmailAddress = EmailAddress
        strPassword = Password
    }
    private fun getStrEmailAddress(): String? {
        return strEmailAddress
    }
    private fun getStrPassword(): String? {
        return strPassword
    }
    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmailAddress()).matches()
    }
    fun isPasswordLengthGreaterThan5(): Boolean {
        return getStrPassword()!!.length > 5
    }
}