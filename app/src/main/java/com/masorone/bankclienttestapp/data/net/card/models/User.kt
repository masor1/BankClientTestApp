package com.masorone.bankclienttestapp.data.net.card.models

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName
import java.util.*

data class User(
    @SerializedName("users") val cardNets: List<Card>
)
