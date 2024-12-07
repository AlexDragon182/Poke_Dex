package com.example.pokedex.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokedex.R
import com.example.pokedex.ViewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Pokemon_List : Fragment(R.layout.fragment_pokemon_list) {

    private val viewModel : MainViewModel by viewModels()
}
