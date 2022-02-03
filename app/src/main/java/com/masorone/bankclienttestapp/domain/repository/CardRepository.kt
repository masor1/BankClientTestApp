package com.masorone.bankclienttestapp.domain.repository

import com.masorone.bankclienttestapp.data.net.card.models.Card

interface CardRepository {

    suspend fun fetch(): List<Card>
    suspend fun save()
}