package com.masorone.bankclienttestapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masorone.bankclienttestapp.R
import com.masorone.bankclienttestapp.data.net.card.models.Card

class RVCardAdapter(
    private val listOfCard: List<Card>
) : RecyclerView.Adapter<RVCardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = listOfCard[position]
        holder.bind(card)
    }

    override fun getItemCount() = listOfCard.size

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val icon = itemView.findViewById<ImageView>(R.id.item_card_icon)
        private val number = itemView.findViewById<TextView>(R.id.item_card_number)
        private val indicator = itemView.findViewById<ImageView>(R.id.item_card_indicator)

        fun bind(card: Card) {
            val resId = when (card.type) {
                "mastercard" -> R.drawable.img_card_logo_master_card
                "visa" -> R.drawable.img_card_logo_visa
                else -> R.drawable.img_card_logo_union_pay
            }
            icon.setImageResource(resId)
            number.text = card.cardNumber

            if (card.isCheck) {
                indicator.visibility = View.VISIBLE
            } else {
                indicator.visibility = View.INVISIBLE
            }
        }
    }
}