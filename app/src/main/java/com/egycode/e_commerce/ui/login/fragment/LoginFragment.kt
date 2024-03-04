package com.egycode.e_commerce.ui.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.egycode.e_commerce.BindingFragment
import com.egycode.e_commerce.R
import com.egycode.e_commerce.databinding.FragmentLoginBinding


class LoginFragment : BindingFragment<FragmentLoginBinding>() {

    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}