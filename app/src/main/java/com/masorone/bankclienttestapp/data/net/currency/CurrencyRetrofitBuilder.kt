package com.masorone.bankclienttestapp.data.net.currency

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyRetrofitBuilder {
    private const val BASE_URL = "https://www.cbr-xml-daily.ru/daily_json.js/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    val apiService: CurrencyService = getRetrofit().create(CurrencyService::class.java)
}