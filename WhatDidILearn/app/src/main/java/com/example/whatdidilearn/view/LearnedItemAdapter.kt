package com.example.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.LearnedItem

class LearnedItemAdapter: RecyclerView.Adapter <LearnedItemAdapter.LearnedItemViewHolder>(){

    // recebe valores da MainActivity
    var learnedItems = listOf<LearnedItem>()


    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      private val titleContainer: TextView = itemView.findViewById(R.id.learnedItemTitle)
      private val descriptionContainer: TextView = itemView.findViewById(R.id.learnedItemDescription)
     // private val learned: view = itemView.findViewById(R.id.learned)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description
            //barracor.back(R.color)
        }

    }

    // inflate retorna uma view
    // retornando para a view meu layout inflado
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LearnedItemAdapter.LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned,parent,false)
        return  LearnedItemViewHolder(view)
    }


    // chamada pelo cycleview na hora de exibir um item (posição especifica)
    // especificar como meus itens irao se comunicar
    override fun onBindViewHolder(holder: LearnedItemAdapter.LearnedItemViewHolder, position: Int) {
        val  learnedItem = learnedItems[position]
        // plotar na tela (biden)
        holder.bind(learnedItem)
    }


    // precisa responder (quantidade de itens que tem na lista)
    override fun getItemCount(): Int {
        return learnedItems.size
    }

}