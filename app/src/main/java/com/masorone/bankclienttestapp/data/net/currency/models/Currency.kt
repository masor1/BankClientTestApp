package com.masorone.bankclienttestapp.data.net.currency.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("ID")
    @Expose
    var ID: String,
    @SerializedName("NumCode")
    @Expose
    var NumCode: String,
    @SerializedName("CharCode")
    @Expose
    var CharCode: String,
    @SerializedName("Nominal")
    @Expose
    var Nominal: Int,
    @SerializedName("Name")
    @Expose
    var Name: String,
    @SerializedName("Value")
    @Expose
    var Value: Double,
    @SerializedName("Previous")
    @Expose
    var Previous: Double
)