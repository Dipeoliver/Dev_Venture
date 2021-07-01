package com.example.whatsappclone.repository

import com.example.whatsappclone.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object UserRepository {
    val db by lazy{Firebase.firestore}

    fun addUser(user: User, onSuccess: ()-> Unit, onFail: (erro: String) ->Unit){
        db.collection("users")
            .document(user.email)
            .set(user)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener{ e ->
                onFail(e.localizedMessage)
            }
    }
}