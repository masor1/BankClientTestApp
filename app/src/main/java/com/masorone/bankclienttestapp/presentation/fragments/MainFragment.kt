package com.masorone.bankclienttestapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.masorone.bankclienttestapp.R

class MainFragment : Fragment() {

    private lateinit var card: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppBarToolsAndNavigation(view)
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

        card = view.findViewById(R.id.main_screen_card_view)
        card.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_cardsFragment)
        }
    }
}