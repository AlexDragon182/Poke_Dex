package com.example.pokedex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.pokedex.R
import com.example.pokedex.RecyclerView.PokemonAdapter
import com.example.pokedex.Retrofit.Models.PokemonResponse
import com.example.pokedex.ViewModel.MainViewModel
import com.example.pokedex.ViewModel.Resource
import com.example.pokedex.databinding.FragmentPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Pokemon_List : Fragment(R.layout.fragment_pokemon_list) {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!
    private val viewModel : MainViewModel by viewModels()
    @Inject
    lateinit var pokeAdapter: PokemonAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPokemon.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    println("success")
                    response.data?.let{
                        pokeAdapter.differ.submitList(PokemonResponse.)
                    }
                }

            }
        })


}

    private fun setupRecyclerView(){// function to setup recycler view
        pokeAdapter = PokemonAdapter(requireContext())// variable newsAdapter set it up to NewsAdapter(the real adapter)
        binding.rvPokemon.apply{   // apply the adapter in the layout
            pokeAdapter = PokemonAdapter // set the adapter to news adapter
            layoutManager = LinearLayoutManager(activity) // set layout Manager to linear Layout Manager activity

        }

    }

    }


