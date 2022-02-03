package com.masorone.bankclienttestapp.data.net.card

import com.masorone.bankclienttestapp.data.net.card.models.User
import retrofit2.http.GET

interface CardService {

    @GET("users.json")
    suspend fun fetchCards(): User
}