package com.masorone.bankclienttestapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.masorone.bankclienttestapp.R
import com.masorone.bankclienttestapp.presentation.adapters.RVCardAdapter

class CardsFragment : Fragment() {

    private val cardsFViewModel by viewModels<CardsFViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewCards = view.findViewById<RecyclerView>(R.id.recycler_view_cards)

        cardsFViewModel.liveDataOfCards.observe(requireActivity()) { listOfCards ->
            val adapter = RVCardAdapter(listOfCards)
            recyclerViewCards.adapter = adapter
        }

        val appBar = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)
        val icon = getDrawable(requireContext(), R.drawable.img_button_back)
        appBar.navigationIcon = icon
        appBar.title = "Мои карты"
    }
}