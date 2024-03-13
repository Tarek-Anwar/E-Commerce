package com.egycode.e_commerce.ui.auth.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.egycode.e_commerce.data.datasource.datastore.UserPreferencesDataSource
import com.egycode.e_commerce.data.repository.user.UserPreferencesRepositoryImp
import com.egycode.e_commerce.utils.BindingFragmentUtils
import com.egycode.e_commerce.databinding.FragmentLoginBinding
import com.egycode.e_commerce.ui.auth.viewmodel.LoginViewModel
import com.egycode.e_commerce.ui.auth.viewmodel.LoginViewModelFactory


class LoginFragment : BindingFragmentUtils<FragmentLoginBinding>() {

    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    private val loginViewModel : LoginViewModel by viewModels{
        LoginViewModelFactory(
            userPrefs= UserPreferencesRepositoryImp(
                userPreferencesDataSource = UserPreferencesDataSource(requireContext())
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}