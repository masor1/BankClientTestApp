package com.masorone.bankclienttestapp.data.repository

import com.masorone.bankclienttestapp.data.net.CloudDataSource
import com.masorone.bankclienttestapp.domain.repository.CardRepository

class CardRepositoryImpl(
    private val cloudDataSource: CloudDataSource.Base
) : CardRepository {

    override suspend fun fetch() = cloudDataSource.fetchCards()

    override suspend fun save() {
        TODO("Not yet implemented")
    }
}