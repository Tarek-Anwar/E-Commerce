package com.egycode.e_commerce.ui.home

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.egycode.e_commerce.R
import com.egycode.e_commerce.data.repository.user.UserPreferencesRepositoryImp
import com.egycode.e_commerce.ui.common.viewmodel.UserViewModel
import com.egycode.e_commerce.ui.common.viewmodel.UserViewModelFactory
import com.egycode.e_commerce.ui.login.AuthActivity
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val userViewModel : UserViewModel by viewModels {
        UserViewModelFactory(UserPreferencesRepositoryImp(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) initSplashScreen()
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(Main) {
            val isUserLoggedIn = userViewModel.isUserLoggedIn().first()
            if (isUserLoggedIn){
                setContentView(R.layout.activity_main)
            }else{
                goToAuthActivity()
            }
        }


    }

    private fun goToAuthActivity() {
        val intent = Intent(this, AuthActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val options = ActivityOptions.makeCustomAnimation(this , android.R.anim.fade_in , android.R.anim.fade_out)
        startActivity(intent , options.toBundle())
    }

    private fun initSplashScreen(){
        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { view ->
            view.view.let { icon ->
                val animator = ValueAnimator
                    .ofInt(icon.bottom, 0)
                    .setDuration(1000)
                animator.addUpdateListener {
                    val value = it.animatedValue as Int
                    icon.layoutParams.width = value
                    icon.layoutParams.height = value
                    icon.requestLayout()
                }
                val animationSet = AnimatorSet()
                animationSet.interpolator = AccelerateDecelerateInterpolator()
                animationSet.play(animator)
                animationSet.start()
            }
        }
    }

}

