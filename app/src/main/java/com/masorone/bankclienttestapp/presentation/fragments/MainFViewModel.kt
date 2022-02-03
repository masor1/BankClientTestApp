package com.masorone.bankclienttestapp.presentation.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masorone.bankclienttestapp.data.net.CloudDataSource
import com.masorone.bankclienttestapp.data.net.card.CardRetrofitBuilder
import com.masorone.bankclienttestapp.data.net.card.models.Card
import com.masorone.bankclienttestapp.data.net.currency.CurrencyRetrofitBuilder
import com.masorone.bankclienttestapp.data.net.currency.models.Valute
import com.masorone.bankclienttestapp.data.repository.CardRepositoryImpl
import com.masorone.bankclienttestapp.domain.usecase.FetchCards
import kotlinx.coroutines.launch

class MainFViewModel : ViewModel() {

    private val cardRepository: CardRepositoryImpl = CardRepositoryImpl(
        CloudDataSource.Base(
            CardRetrofitBuilder.apiService,
            CurrencyRetrofitBuilder.apiService
        )
    )
    private val fetchCards = FetchCards(cardRepository)
    var liveDataOfCards = MutableLiveData<List<Card>>()
    var liveDataOfCurrency = MutableLiveData<Valute>()

    init {
        viewModelScope.launch {
            liveDataOfCards.postValue(fetchCards.execute())
        }
    }
}