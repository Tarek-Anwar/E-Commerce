package com.egycode.e_commerce.ui.login.fragment

import android.os.Bundle
import android.view.View
import com.egycode.e_commerce.utils.BindingFragmentUtils
import com.egycode.e_commerce.databinding.FragmentLoginBinding


class LoginFragmentUtils : BindingFragmentUtils<FragmentLoginBinding>() {

    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}