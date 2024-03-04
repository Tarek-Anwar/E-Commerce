package com.egycode.e_commerce.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.egycode.e_commerce.R
import com.egycode.e_commerce.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private var _binding : ActivityAuthBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this,R.layout.activity_auth)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}