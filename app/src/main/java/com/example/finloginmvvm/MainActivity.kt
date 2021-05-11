package com.example.finloginmvvm

import android.R
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.finloginmvvm.Model.LoginUser
import com.example.finloginmvvm.ViewModel.LoginViewModel
import java.util.*


class MainActivity : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.MainActivity)
        binding.setLifecycleOwner(this)
        binding.setLoginViewModel(loginViewModel)
        loginViewModel!!.user.observe(this, object : Observer<LoginUser?>() {
            fun onChanged(@Nullable loginUser: LoginUser) {
                if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrEmailAddress())) {
                    binding.txtEmailAddress.setError("Enter an E-Mail Address")
                    binding.txtEmailAddress.requestFocus()
                } else if (!loginUser.isEmailValid()) {
                    binding.txtEmailAddress.setError("Enter a Valid E-mail Address")
                    binding.txtEmailAddress.requestFocus()
                } else if (TextUtils.isEmpty(Objects.requireNonNull(loginUser).getStrPassword())) {
                    binding.txtPassword.setError("Enter a Password")
                    binding.txtPassword.requestFocus()
                } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.txtPassword.setError("Enter at least 6 Digit password")
                    binding.txtPassword.requestFocus()
                } else {
                    binding.lblEmailAnswer.setText(loginUser.getStrEmailAddress())
                    binding.lblPasswordAnswer.setText(loginUser.getStrPassword())
                }
            }
        })
    }
}

class ActivityMainBinding {

    val txtEmailAddress: Any
}
