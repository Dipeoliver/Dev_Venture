package com.example.colormyviews

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var boxOne : TextView
    lateinit var boxTwo : TextView
    lateinit var boxThree: TextView
    lateinit var boxFour: TextView
    lateinit var boxFive: TextView

    var boxOneColor = R.color.gray
    var boxTwoColor = R.color.gray
    var boxThreeColor = R.color.gray
    var boxFourColor = R.color.gray
    var boxFiveColor = R.color.gray

    // criei a variavel
    val sharedPreferences : SharedPreferences

    // get personalizado ( retorna valor variável)
    get () {
        return this.getSharedPreferences("colors", Context.MODE_PRIVATE)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxOne = findViewById<TextView>(R.id.boxOne)
        boxTwo = findViewById<TextView>(R.id.boxTwo)
        boxThree = findViewById<TextView>(R.id.boxThree)
        boxFour = findViewById<TextView>(R.id.boxFour)
        boxFive = findViewById<TextView>(R.id.boxFive)


         // pego valor gravado e passo para caixas ao carregar
        boxOneColor = sharedPreferences.getInt("boxOne",R.color.gray)
        boxOne.setBackgroundResource (boxOneColor)

        boxTwoColor = sharedPreferences.getInt("boxTwo",R.color.gray)
        boxTwo.setBackgroundResource (boxTwoColor)

        boxThreeColor = sharedPreferences.getInt("boxThree",R.color.gray)
        boxThree.setBackgroundResource (boxThreeColor)

        boxFourColor = sharedPreferences.getInt("boxFour",R.color.gray)
        boxFour.setBackgroundResource (boxFourColor)

        boxFiveColor = sharedPreferences.getInt("boxFive",R.color.gray)
        boxFive.setBackgroundResource (boxFiveColor)
        //--------------------------------------------------------------------

        // declarar variavel que irá receber cor e evitar iniciar com valores nulos
        var changeColor =  R.color.gray

        // declaração dos botões
        var buttonRed = findViewById<Button>(R.id.buttonRed)
        var buttonGreen = findViewById<Button>(R.id.buttonGreen)
        var buttonYellow = findViewById<Button>(R.id.buttonYellow)
        var buttonReset = findViewById<Button>(R.id.buttonReset)


        // Salva a cor do botao na variavel changecolor
        buttonRed.setOnClickListener {
             changeColor =  R.color.red
        }
        buttonYellow.setOnClickListener {
             changeColor =  R.color.yellow
        }
        buttonGreen.setOnClickListener {
             changeColor =  R.color.green
        }

        buttonReset.setOnClickListener {
            boxOne.setBackgroundResource(R.color.gray)
            boxTwo.setBackgroundResource(R.color.gray)
            boxThree.setBackgroundResource(R.color.gray)
            boxFour.setBackgroundResource(R.color.gray)
            boxFive.setBackgroundResource(R.color.gray)
            changeColor =  R.color.gray
            boxOneColor = changeColor
            boxTwoColor = changeColor
            boxThreeColor = changeColor
            boxFourColor = changeColor
            boxFiveColor = changeColor
        }

        // Ao clicar no box atribui valor que esta na variavel changecolor
        // ---------------------------------
        boxOne.setOnClickListener {
            boxOne.setBackgroundResource(changeColor)
            boxOneColor = changeColor
        }
        boxTwo.setOnClickListener {
            boxTwo.setBackgroundResource(changeColor)
            boxTwoColor = changeColor
        }
        boxThree.setOnClickListener {
            boxThree.setBackgroundResource(changeColor)
            boxThreeColor = changeColor
        }
        boxFour.setOnClickListener {
            boxFour.setBackgroundResource(changeColor)
            boxFourColor = changeColor
        }
        boxFive.setOnClickListener {
            boxFive.setBackgroundResource(changeColor)
            boxFiveColor = changeColor
        }


        //------------------------------------

    }

    // Ao finalizar salva os valores banco local
    override fun onStop() {
        super.onStop()
        // salvar a cor ao fechar
        val editor = sharedPreferences.edit()
        editor.putInt("boxOne",boxOneColor)
        editor.putInt("boxTwo",boxTwoColor)
        editor.putInt("boxThree",boxThreeColor)
        editor.putInt("boxFour",boxFourColor)
        editor.putInt("boxFive",boxFiveColor)
        editor.commit()
    }
}