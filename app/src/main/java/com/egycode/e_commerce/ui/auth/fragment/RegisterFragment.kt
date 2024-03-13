package com.egycode.e_commerce.ui.auth.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.egycode.e_commerce.R
import com.egycode.e_commerce.databinding.FragmentRegisterBinding
import com.egycode.e_commerce.utils.BindingFragmentUtils


class RegisterFragment : BindingFragmentUtils<FragmentRegisterBinding>() {

    override fun getViewBinding(): FragmentRegisterBinding = FragmentRegisterBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}