package com.egycode.e_commerce

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) initSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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