package com.example.whatsappclone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatsappclone.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {
    private val splahViewModel = SplashViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splahViewModel.loadView()

    }
}