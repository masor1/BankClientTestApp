package com.masorone.bankclienttestapp.domain.usecase

import com.masorone.bankclienttestapp.domain.repository.CardRepository

class FetchCards(private val cardRepository: CardRepository) {

    suspend fun execute() = cardRepository.fetch()
}