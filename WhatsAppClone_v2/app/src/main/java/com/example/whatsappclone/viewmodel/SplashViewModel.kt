package com.example.whatsappclone.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.whatsappclone.view.LoginActivity
import com.example.whatsappclone.view.MainActivity
import com.google.firebase.auth.FirebaseAuth

class SplashViewModel (val context: Context) {

    fun loadView(){
        val user = FirebaseAuth.getInstance().currentUser

        val intent: Intent = if(user == null){
            Intent(context, LoginActivity::class.java)
        }else{
            Intent(context, MainActivity::class.java)
        }
        context.startActivity((intent))
        (context as Activity).finish()
    }
}