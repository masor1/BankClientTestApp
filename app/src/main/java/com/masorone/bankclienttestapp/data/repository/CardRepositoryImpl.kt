package com.masorone.bankclienttestapp.data.repository

import com.masorone.bankclienttestapp.data.net.card.CloudDataSource
import com.masorone.bankclienttestapp.domain.repository.CardRepository

class CardRepositoryImpl(
    private val cloudDataSource: CloudDataSource.Base
) : CardRepository {

    override suspend fun fetch() = cloudDataSource.fetch()

    override suspend fun save() {
        TODO("Not yet implemented")
    }
}