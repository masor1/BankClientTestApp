package com.masorone.bankclienttestapp.data.net.card.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("users") val cardNets: List<Card>
)
