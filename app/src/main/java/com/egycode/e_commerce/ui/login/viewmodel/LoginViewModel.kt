package com.egycode.e_commerce.ui.login.viewmodel

import androidx.lifecycle.ViewModel
import com.egycode.e_commerce.data.repository.user.UserPreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel (
    val userPrefs : UserPreferencesRepository
) : ViewModel(){
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")



}