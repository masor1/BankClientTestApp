package com.masorone.bankclienttestapp.data.net.card.models

import com.google.gson.annotations.SerializedName

data class Card (
    var id: Int = -1,
    @SerializedName("card_number") var cardNumber: String,
    @SerializedName("type") var type: String,
    @SerializedName("cardholder_name") var cardholderName: String,
    @SerializedName("valid") var valid: String,
    @SerializedName("balance") var balance: Double,
    @SerializedName("transaction_history") var transactionHistory: ArrayList<Transaction>,
    var isCheck: Boolean = false
) {
    fun check() {
        isCheck = true
    }
    fun unCheck() {
        isCheck = false
    }
}
