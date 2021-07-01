package com.example.whatsappclone.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.whatsappclone.view.MainActivity
import com.example.whatsappclone.model.User
import com.example.whatsappclone.repository.UserRepository
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel (val context: Context) {

    fun activityResult(resultCode: Int, data: Intent?) {
        val response = IdpResponse.fromResultIntent(data)

        if (resultCode == Activity.RESULT_OK) {
            // Successfully signed in
            val current = FirebaseAuth.getInstance().currentUser?.apply {
                val user: User = User(name = this.displayName ?: "NO NAME",
                    email = this.email ?: "NO EMAIL", id = this.uid)
                UserRepository.addUser(user,{
                    goToMain()
                },{
                    failTOLogin(it)
                })
            }
        } else {
//                failTOLogin(response?error?.message)
            response?.error?.message?.let { failTOLogin(it) }
        }
    }

    fun failTOLogin(message: String){
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()
    }

    fun goToMain(){
        val intent: Intent = Intent(context, MainActivity::class.java)
        context.startActivity((intent))
        (context as Activity).finish()
    }
}