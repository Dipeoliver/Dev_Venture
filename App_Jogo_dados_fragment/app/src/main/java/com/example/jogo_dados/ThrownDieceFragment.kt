package com.example.jogo_dados

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.jogo_dados.databinding.FragmentThrownDieceBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ThrownDieceFragment : Fragment() {

    private var binding: FragmentThrownDieceBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThrownDieceBinding.inflate(inflater,container,false)

        val imgDado1 = binding?.dado01
        val imgDado2 = binding?.dado02
        val welcomemessage = binding?.UserName
        val btn = binding?.btnJogar
        val sharedButton = binding?.share


        //val playerName = intent.getStringExtra("playername")
        val playerName = "playername"
//        val message = getString(R.string.Welcome, playerName)
        val message = "será hoje seu dia de sorte. ${arguments?.getString( playerName)}"
        welcomemessage?.text = message

        // irá gerar uma lista de imagens
        val images = listOf(R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6)

        btn?.setOnClickListener{
            imgDado1?.setImageResource(images.random())
            imgDado2?.setImageResource(images.random())

        }

        sharedButton?.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "VOÇÊ É SORTUDO")
            intent.setPackage("com.whatsapp")
            intent.type = "text/plain"

            // verifico se a activity existe / veirifco se packageManager é nulo se nao chamo o this
            activity?.packageManager?.run {
                // verifico se o retorno da chamada nao e nulo
                if (intent.resolveActivity(this) != null ){
                startActivity(intent)
                }else{
                    // quando usar Toast em fragment tem de mudar this, por context
                Toast.makeText(context, "Você nao tem o WhatsApp instalado", Toast.LENGTH_SHORT).show()
                }
            }

        }
        return binding?.root
    }


}