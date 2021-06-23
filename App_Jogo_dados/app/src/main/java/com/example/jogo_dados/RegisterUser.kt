package com.example.jogo_dados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val playerName = findViewById<EditText>(R.id.editTextPlayerName)
        val buttonInit = findViewById<Button>(R.id.btn_jogar)


        buttonInit.setOnClickListener{
            var name = playerName.text.toString()

            // criar esquema de navegacao para outra activity passando nome usuario
            // tenho de passar 2 parametros (contexto atual,passar o componente que queremos abrir)
            val intent = Intent(this, MainActivity::class.java)

            // valores que irei enviar para outra activity(chave valor)
            intent.putExtra("playername", name)

            // iniciar activity
            startActivity(intent)
        }
    }
}