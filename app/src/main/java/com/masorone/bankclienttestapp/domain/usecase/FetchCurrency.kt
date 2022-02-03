package com.masorone.bankclienttestapp.domain.usecase

import com.masorone.bankclienttestapp.domain.repository.CurrencyRepository

class FetchCurrency(private var currencyRepository: CurrencyRepository) {

    suspend fun execute() = currencyRepository.fetchCurrencys()
}