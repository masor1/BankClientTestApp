package com.masorone.bankclienttestapp.data.net.currency

import com.masorone.bankclienttestapp.data.net.currency.models.Valute
import retrofit2.http.GET

interface CurrencyService {

    @GET("/")
    suspend fun fetchCurrency(): Valute
}