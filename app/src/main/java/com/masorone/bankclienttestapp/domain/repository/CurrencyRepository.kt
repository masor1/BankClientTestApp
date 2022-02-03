package com.masorone.bankclienttestapp.domain.repository

import com.masorone.bankclienttestapp.data.net.currency.models.Valute

interface CurrencyRepository {

    suspend fun fetchCurrencys(): Valute
}