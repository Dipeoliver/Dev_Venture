package com.example.jogo_dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val valor1 = findViewById<ImageView>(R.id.dado01)
        val valor2 = findViewById<ImageView>(R.id.dado02)
        val btn = findViewById(R.id.btn_jogar) as Button

        // irá gerar uma lista de imagens
        val images.listof(R.drawble.dice_1,R.drawble.dice_2,R.drawble.dice_3,R.drawble.dice_4,R.drawble.dice_5,R.drawble.dice_6)

        btn.setOnClickListener{
            dado01.setImageResource(images.random())
            dado02.setImageResource(images.random())

            //valor1.text = randon().toString()
            //valor2.text = randon().toString()
        }

    }
    private fun geraraleatorio() : Int {
        return (0..5).random()
    }

}