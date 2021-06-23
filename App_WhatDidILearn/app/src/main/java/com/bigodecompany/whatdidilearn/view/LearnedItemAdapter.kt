package com.bigodecompany.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bigodecompany.whatdidilearn.R
import com.bigodecompany.whatdidilearn.entities.LearnedItem

class LearnedItemAdapter : RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnedItems = listOf<LearnedItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class LearnedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleContainer: TextView = itemView.findViewById(R.id.learnedItemTitle)
        private val descriptionContainer: TextView =
            itemView.findViewById(R.id.learnedItemsRecyclerView)
        private val understandingLevelContainer: View =
            itemView.findViewById(R.id.understandingLevelContainer)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description
            understandingLevelContainer.setBackgroundResource(learnedItem.understandingLevel.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item_layout, parent, false)

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem = learnedItems[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int = learnedItems.size
}