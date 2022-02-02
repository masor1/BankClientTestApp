package com.masorone.bankclienttestapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.masorone.bankclienttestapp.R

class CardsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppBarToolsAndNavigation()
    }

    private fun setAppBarToolsAndNavigation() {
        val appBar = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)
        appBar.navigationIcon = requireActivity().getDrawable(R.drawable.img_button_back)
        appBar.title = "Мои карты"
    }
}