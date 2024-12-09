package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokedex.R
import com.example.pokedex.ViewModel.MainViewModel
import com.example.pokedex.databinding.FragmentPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Pokemon_List : Fragment(R.layout.fragment_pokemon_list) {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }



}
