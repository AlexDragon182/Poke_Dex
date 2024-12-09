package com.example.pokedex.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.pokedex.R
import com.example.pokedex.ViewModel.MainViewModel
import com.example.pokedex.databinding.FragmentPokemonListBinding
import com.example.pokedex.databinding.FragmentPokemonStatsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonStats : Fragment(R.layout.fragment_pokemon_stats) {
    private var _binding: FragmentPokemonStatsBinding? = null
    private val binding get() = _binding!!
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            super.onCreate(savedInstanceState)
            _binding = FragmentPokemonStatsBinding.inflate(inflater, container, false)
            return binding.root
    }



    }
