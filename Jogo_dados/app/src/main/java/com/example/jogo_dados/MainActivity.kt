package com.example.jogo_dados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imgDado1 = findViewById<ImageView>(R.id.dado01)
        val imgDado2 = findViewById<ImageView>(R.id.dado02)
        val welcomemessage = findViewById<TextView>(R.id.UserName)
        val btn = findViewById<Button>(R.id.btn_jogar)
        val sharedButton = findViewById<FloatingActionButton>(R.id.share)

        // o intent ja contempla o metodo (get e set nele)
        val playerName = intent.getStringExtra("playername")

        //   acessar um resource de uma classe kotlin *****
        //   resources.getString(R.string.Welcome)

        // passar valores para o campo de texto
        // pode se usar exemplo abaixo ***
        //val message =  "${resources.getString(R.string.Welcome)} $playerName"

        //ou

        val message = getString(R.string.Welcome, playerName)
        welcomemessage.text = message


        // irá gerar uma lista de imagens
        val images = listOf(R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6)

        btn.setOnClickListener{
            imgDado1.setImageResource(images.random())
            imgDado2.setImageResource(images.random())

        }



        sharedButton.setOnClickListener{
            // passando para a intent uma ação que quero executar
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "VOÇÊ É SORTUDO")

            // especificar com qual aplicativo quero compartilhar, se nao colocar nada abre geral
            intent.setPackage("com.whatsapp")

            // abaixo para o sistema operacional saber que tipo de arquivo estou passando
            intent.type = "text/plain"

            // verificar se a activity(app) existe localmente se nao vai para a loja
            if(intent.resolveActivity(this.packageManager) != null){
            // chamar start activity
            startActivity(intent)
            }else
            {
                Toast.makeText(this, "Você nao tem o WhatsApp instalado", Toast.LENGTH_SHORT).show()
                // abaixo chamar loja da google para buscar aplicativo
               // startActivity(intent.setPackage("aw.ds"))
            }

        }
    }
//    private fun geraraleatorio() : Int {
//        return (0..5).random()
//    }
}