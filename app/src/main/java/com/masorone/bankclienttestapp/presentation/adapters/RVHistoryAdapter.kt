package com.masorone.bankclienttestapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masorone.bankclienttestapp.R
import com.masorone.bankclienttestapp.data.net.card.models.Transaction

class RVHistoryAdapter(private val list: MutableList<Transaction>) :
    RecyclerView.Adapter<RVHistoryAdapter.HistoryViewHolder>() {

    var index: Float = 0.0f
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.history_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val transaction = list[position]
        holder.bind(transaction)
    }

    override fun getItemCount() = list.size

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val logo = itemView.findViewById<ImageView>(R.id.item_history_logo)
        private val name = itemView.findViewById<TextView>(R.id.item_history_name)
        private val date = itemView.findViewById<TextView>(R.id.item_history_date)
        private val currencyPrice = itemView.findViewById<TextView>(R.id.item_currency_price)
        private val price = itemView.findViewById<TextView>(R.id.item_price)

        fun bind(transaction: Transaction) {
            Glide.with(itemView.context).load(transaction.iconUrl).into(logo);
            name.text = transaction.title
            date.text = transaction.date
            currencyPrice.text = String.format("%.2f", transaction.amount.toFloat() * index)
            price.text = transaction.amount
        }
    }
}