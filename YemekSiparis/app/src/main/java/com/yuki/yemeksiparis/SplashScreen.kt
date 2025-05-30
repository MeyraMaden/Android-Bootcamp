package com.yuki.yemeksiparis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.yuki.yemeksiparis.databinding.ActivitySplashScreenBinding
import java.lang.Exception

class SplashScreen : AppCompatActivity() {

    private lateinit var tasarim : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen)

        SplashScreenAnimation()
        SplashScreenAnimationThread()

    }

    fun SplashScreenAnimation() {
        val splashImageAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_image_animation)
        val splashTextNomAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_text_nom_animation)
        val splashTextNomnomAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_text_nomnom_animation)

        tasarim.splashScreenImageView.startAnimation(splashImageAnimation)
        tasarim.splashTextNom.startAnimation(splashTextNomAnimation)
        tasarim.splashTextNomnom.startAnimation(splashTextNomnomAnimation)
    }

    fun SplashScreenAnimationThread() {
        //Splash Screen ekranı için bir Thread oluşturuyoruz.
        val background = object : Thread() {
            override fun run() {
                try {
                    //thread 5sn yani 5000ms uyusun
                    Thread.sleep(5000)
                    //intent ile splash ekranından sonra MainActivity ekranı açılsın diyoruz.
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                } catch (e : Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}