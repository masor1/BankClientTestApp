package com.masorone.bankclienttestapp.data.repository

import com.masorone.bankclienttestapp.data.shared_pref.SharedDataSource
import com.masorone.bankclienttestapp.domain.repository.CheckIdRepository

class SharedRepositoryImpl(private val sharedDataSource: SharedDataSource) : CheckIdRepository {

    override fun save(id: Int) = sharedDataSource.save(id)
    override fun fetch() = sharedDataSource.fetch()
}