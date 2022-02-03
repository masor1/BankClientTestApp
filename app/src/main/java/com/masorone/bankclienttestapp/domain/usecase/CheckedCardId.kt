package com.masorone.bankclienttestapp.domain.usecase

import com.masorone.bankclienttestapp.domain.repository.CheckIdRepository

class CheckedCardId(private val checkIdRepository: CheckIdRepository) {

    fun fetch() = checkIdRepository.fetch()
    fun save(id: Int) = checkIdRepository.save(id)
}