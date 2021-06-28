package com.example.jogo_dados

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.jogo_dados.databinding.FragmentRegisterUserBinding


class RegisterUserFragment : Fragment() {
    private  var binding: FragmentRegisterUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //pegamos o retorno da variavel inflate e colocamos na binding
        binding = FragmentRegisterUserBinding.inflate(inflater,container,false)

        val playerName = binding?.editTextPlayerName ?:"Jogador 1"
        val buttonInit = binding?.buttonEntrar

        buttonInit?.setOnClickListener{
            // acessar uma classe xml em um arquivo kotlin
            // bundlle é como se fosse um envelope
            findNavController().navigate(R.id.action_registerUserFragment_to_thrownDieceFragment,
                bundleOf("nomeJogador" to playerName))
        }
        return binding?.root
    }

}