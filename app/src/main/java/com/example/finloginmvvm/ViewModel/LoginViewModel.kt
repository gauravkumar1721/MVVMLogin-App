package com.example.finloginmvvm.ViewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finloginmvvm.Model.LoginUser


class LoginViewModel : ViewModel() {
    var EmailAddress = MutableLiveData<String>()
    var Password = MutableLiveData<String>()
    var userMutableLiveData: MutableLiveData<LoginUser>? = null
    val user: MutableLiveData<LoginUser>
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData as MutableLiveData<LoginUser>
        }

    fun onClick(view: View?) {
        val loginUser = LoginUser(EmailAddress.value, Password.value)
        userMutableLiveData!!.setValue(loginUser)
    }
}