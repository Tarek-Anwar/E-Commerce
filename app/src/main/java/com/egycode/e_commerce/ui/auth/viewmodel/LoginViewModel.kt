package com.egycode.e_commerce.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.egycode.e_commerce.data.repository.user.UserPreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel (
    val userPrefs : UserPreferencesRepository
) : ViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
}
class LoginViewModelFactory(
    private val userPrefs: UserPreferencesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return LoginViewModel(userPrefs) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
