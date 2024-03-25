package com.egycode.e_commerce.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.egycode.e_commerce.R
import com.egycode.e_commerce.data.model.Resource
import com.egycode.e_commerce.data.repository.auth.FirebaseAuhRepo
import com.egycode.e_commerce.data.repository.user.UserPreferencesRepository
import com.egycode.e_commerce.utils.isValidEmail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LoginViewModel(
    val userPrefs: UserPreferencesRepository,
    private val authRepo: FirebaseAuhRepo
) : ViewModel() {

    val loginState = MutableSharedFlow<Resource<String>>()
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    private val isLoginValid: Flow<Boolean> = combine(email, password) { email, password ->
        email.isValidEmail() && password.length >= 6
    }

    fun login() {
        viewModelScope.launch {
            if (isLoginValid.first()) {
                authRepo.loginWithEmailAndPassword(email.value, password.value).onEach { resource ->
                    when (resource) {
                        is Resource.Loading -> loginState.emit(Resource.Loading())
                        is Resource.Success -> {
                            loginState.emit(
                                Resource.Success(
                                    resource.data ?: "Login Successfully"
                                )
                            )
                            //   userPrefs.saveLoginState(true)
                        }

                        is Resource.Error -> loginState.emit(
                            Resource.Error(
                                resource.exception ?: Exception("Unknown error")
                            )
                        )

                    }
                }.launchIn(viewModelScope)
            } else {
                loginState.emit(Resource.Error(Exception("Invalid Email or Password")))
            }
        }
    }


}

class LoginViewModelFactory(
    private val userPrefs: UserPreferencesRepository,
    val authRepo: FirebaseAuhRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return LoginViewModel(userPrefs, authRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
