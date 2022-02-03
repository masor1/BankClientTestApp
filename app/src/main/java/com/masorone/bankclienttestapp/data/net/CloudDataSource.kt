package com.masorone.bankclienttestapp.data.net

import com.masorone.bankclienttestapp.data.net.card.CardService
import com.masorone.bankclienttestapp.data.net.card.models.Card
import com.masorone.bankclienttestapp.data.net.currency.CurrencyService
import com.masorone.bankclienttestapp.data.net.currency.models.Valute

interface CloudDataSource {
    suspend fun fetchCards(): List<Card>
    suspend fun fetchCurrency(): Valute

    class Base(
        private val cardApiService: CardService,
        private val currencyApiService: CurrencyService,
    ) : CloudDataSource {

        override suspend fun fetchCards() = cardApiService.fetchCards().cardNets
        override suspend fun fetchCurrency() = currencyApiService.fetchCurrency()
    }
}