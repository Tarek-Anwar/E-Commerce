package com.egycode.e_commerce.ui.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel()  {


    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun login(){
    }

    fun loginWithGoogle(){
    }

    fun loginWithFacebook(){

    }
}