package com.masorone.bankclienttestapp.data.net.currency.models

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Valute(
    @SerializedName("Valute")
    @Expose
    var valute: JsonObject? = null
)
