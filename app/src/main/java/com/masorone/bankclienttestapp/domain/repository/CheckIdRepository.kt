package com.masorone.bankclienttestapp.domain.repository

interface CheckIdRepository {

    fun save(id: Int)
    fun fetch(): Int
}