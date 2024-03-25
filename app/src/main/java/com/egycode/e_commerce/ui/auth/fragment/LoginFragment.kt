package com.egycode.e_commerce.ui.auth.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.egycode.e_commerce.R
import com.egycode.e_commerce.data.datasource.datastore.UserPreferencesDataSource
import com.egycode.e_commerce.data.model.Resource
import com.egycode.e_commerce.data.repository.auth.FirebaseAuthRepoImpl
import com.egycode.e_commerce.data.repository.user.UserPreferencesRepositoryImp
import com.egycode.e_commerce.databinding.FragmentLoginBinding
import com.egycode.e_commerce.ui.auth.viewmodel.LoginViewModel
import com.egycode.e_commerce.ui.auth.viewmodel.LoginViewModelFactory
import com.egycode.e_commerce.ui.common.views.ProgressDialog
import com.egycode.e_commerce.utils.BindingFragmentUtils
import kotlinx.coroutines.launch


class LoginFragment : BindingFragmentUtils<FragmentLoginBinding>() {

    private val processDialog by lazy { ProgressDialog.createProgressDialog(requireActivity()) }
    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(
            UserPreferencesRepositoryImp(UserPreferencesDataSource(requireContext())),
            FirebaseAuthRepoImpl()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = loginViewModel

        initViewModel()

        binding.registerLayout.setOnClickListener{
            goToRegister()
        }

    }

    private fun initViewModel() {
        lifecycleScope.launch {
            loginViewModel.loginState.collect { state ->
                state.let { resources ->
                    when (resources) {
                        is Resource.Loading -> {
                            processDialog.show()
                        }

                        is Resource.Success -> {
                            processDialog.dismiss()
                            Toast.makeText(
                                requireContext(),
                                state.data,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        is Resource.Error -> {
                            processDialog.dismiss()
                            Toast.makeText(
                                requireContext(),
                                resources.exception?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                }

            }

        }
    }

    private fun goToRegister(){
        findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }


}