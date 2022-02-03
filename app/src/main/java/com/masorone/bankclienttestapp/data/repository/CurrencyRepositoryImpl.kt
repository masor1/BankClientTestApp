package com.masorone.bankclienttestapp.data.repository

import com.masorone.bankclienttestapp.data.net.CloudDataSource
import com.masorone.bankclienttestapp.domain.repository.CurrencyRepository

class CurrencyRepositoryImpl(
    private var cloudDataSource: CloudDataSource
) : CurrencyRepository {

    override suspend fun fetchCurrencys() = cloudDataSource.fetchCurrency()
}