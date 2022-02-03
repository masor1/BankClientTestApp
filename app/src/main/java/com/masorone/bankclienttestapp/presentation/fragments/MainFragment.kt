package com.masorone.bankclienttestapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.masorone.bankclienttestapp.R
import com.masorone.bankclienttestapp.data.repository.SharedRepositoryImpl
import com.masorone.bankclienttestapp.data.shared_pref.SharedDataSource
import com.masorone.bankclienttestapp.domain.usecase.CheckedCardId
import com.masorone.bankclienttestapp.presentation.adapters.RVHistoryAdapter

class MainFragment : Fragment() {

    private val mainViewModel by viewModels<MainFViewModel>()
    private lateinit var adapter: RVHistoryAdapter
    private lateinit var rv: RecyclerView
    private lateinit var icon: ImageView
    private lateinit var cardNumber: TextView
    private lateinit var userName: TextView
    private lateinit var date: TextView
    private lateinit var currencyBalance: TextView
    private lateinit var balance: TextView
    private lateinit var cardView: View
    private lateinit var radioCurrencyButtons: RadioGroup
    private var index = PRICE_GBP

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppBarToolsAndNavigation(view)

        icon = view.findViewById(R.id.main_screen_card_type)
        cardNumber = view.findViewById(R.id.main_screen_card_number)
        userName = view.findViewById(R.id.main_screen_card_user_name)
        date = view.findViewById(R.id.main_screen_card_valid_thru)
        currencyBalance = view.findViewById(R.id.main_screen_card_balance_currency)
        balance = view.findViewById(R.id.main_screen_card_balance)
        rv = view.findViewById(R.id.recycler_view_history)
        radioCurrencyButtons = view.findViewById(R.id.main_screen_currency_group)

        radioCurrencyButtons.setOnCheckedChangeListener { radioGroup, _ ->
            index = when (radioGroup?.checkedRadioButtonId) {
                R.id.main_screen_currency_gbp -> PRICE_GBP
                R.id.main_screen_currency_eur -> PRICE_EUR
                else -> PRICE_RUB
            }
            val res = balance.text.toString().toFloat()
            adapter.index = index
            currencyBalance.text = String.format("%.2f", res * index)
        }

        mainViewModel.liveDataOfCards.observe(requireActivity()) {

            val cardChecked = it[CheckedCardId(
                SharedRepositoryImpl(
                    SharedDataSource.Base(requireContext())
                )
            ).fetch()]

            val resId = when (cardChecked.type) {
                "mastercard" -> R.drawable.img_card_logo_master_card
                "visa" -> R.drawable.img_card_logo_visa
                else -> R.drawable.img_card_logo_union_pay
            }

            icon.setImageResource(resId)
            cardNumber.text = cardChecked.cardNumber
            userName.text = cardChecked.cardholderName
            date.text = cardChecked.valid
            currencyBalance.text = String.format("%.2f", cardChecked.balance.toFloat() * index)
            balance.text = cardChecked.balance.toString()
            adapter = RVHistoryAdapter(cardChecked.transactionHistory)
            adapter.index = index
            rv.adapter = adapter
        }
    }

    private fun setAppBarToolsAndNavigation(view: View) {
        val appBar = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)
        appBar.navigationIcon = null
        appBar.title = "Главная"

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })

        cardView = view.findViewById(R.id.main_screen_card_view)
        cardView.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_cardsFragment)
        }
    }

    private companion object {
        const val PRICE_GBP = 0.73f
        const val PRICE_EUR = 0.88f
        const val PRICE_RUB = 76.36f
    }
}