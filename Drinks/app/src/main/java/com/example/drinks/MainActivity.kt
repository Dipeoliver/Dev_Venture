package com.example.drinks

import android.graphics.drawable.DrawableContainer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.drinks.data.DrinkListRemoteEntity
import com.example.drinks.data.network.CockTailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var drinkName: TextView
    lateinit var drinkContainer: ConstraintLayout
    lateinit var drinkImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drinkName = findViewById(R.id.drinkName)
        drinkContainer = findViewById(R.id.drinkContainer)
        drinkImage = findViewById(R.id.drinkImage)


        // quando inicializa pega nome drink
        // quando clica na tela pega nome drink
        getDrink()

        drinkContainer.setOnClickListener{
            getDrink()
        }
    }


    private fun getDrink(){
        // executar requisição
        lifecycleScope.launch {
            try{
                val response = requestDrinks()
                val drink = response.drinksList.random()
                drinkName.text = drink.strDrink



                // carregar foto com biblioteca
                Glide.with(this@MainActivity)
                    .load(drink.strDrinkThumb)
                    .into(drinkImage)

            }catch (e: Exception){
                Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
            }
        }
        // a partir da resposta escolher um drink aleatorio
        // colocar nome do drink aleatorio no textbox

    }
    // ecapsilando requisicao de rede que vai ate a URL
    private suspend fun requestDrinks():DrinkListRemoteEntity{
        return withContext(Dispatchers.IO){
            CockTailService.service.getDrinks()
        }
    }

}