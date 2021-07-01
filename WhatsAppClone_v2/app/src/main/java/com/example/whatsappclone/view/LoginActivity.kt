package com.example.whatsappclone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.example.whatsappclone.R
import com.example.whatsappclone.viewmodel.LoginViewModel
import com.firebase.ui.auth.AuthUI

class LoginActivity : AppCompatActivity() {

    private val loginViewModel = LoginViewModel(this)

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
            loginViewModel.activityResult(result.resultCode, result.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build())

        findViewById<Button>(R.id.btn_login).setOnClickListener{
            resultLauncher.launch(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build()
            )
        }
    }
}

