package com.masorone.bankclienttestapp.data.net.card.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmModel

data class Transaction(
    @SerializedName("title") var title: String,
    @SerializedName("icon_url") var iconUrl: String,
    @SerializedName("date") var date: String,
    @SerializedName("amount") var amount: String
) : RealmModel

