package com.masorone.bankclienttestapp.data.net.card

import com.masorone.bankclienttestapp.data.net.card.models.Card

interface CloudDataSource {
    suspend fun fetch(): List<Card>

    class Base(private val apiService: CardService) : CloudDataSource {
        override suspend fun fetch() = apiService.fetchCards().cardNets
    }
}