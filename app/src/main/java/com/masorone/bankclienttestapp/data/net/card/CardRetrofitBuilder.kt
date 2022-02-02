package com.masorone.bankclienttestapp.data.net.card

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CardRetrofitBuilder {
    private const val BASE_URL = "https://hr.peterpartner.net/test/android/v1/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: CardService = getRetrofit().create(CardService::class.java)
}