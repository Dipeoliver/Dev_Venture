        
        
        val valor1 = findViewById<ImageView>(R.id.dado01)
        val valor2 = findViewById<ImageView>(R.id.dado02)
        val btn = findViewById(R.id.btnAleatorio) as Button

        // irá gerar uma lista de imagens
        val images.listof(R.drawble.dice_1,R.drawble.dice_2,R.drawble.dice_3, \n
        R.drawble.dice_4,R.drawble.dice_5,R.drawble.dice_6)

        btn.setOnClickListener{             
            dado01.setImageResource(images.get(randon()))
            valor1.text = randon().toString()
            valor2.text = randon().toString() 
            }
    
    private fun randon() : Int {
        return (0..5).random()
    }
