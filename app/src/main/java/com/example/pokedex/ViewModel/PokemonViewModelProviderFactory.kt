package com.example.pokedex.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.ViewModel.Repositories.MainRepository

class PokemonViewModelProviderFactory(
    val app: Application,
    val pokeRepository: MainRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {//return a new instance of a newsViewModel with the news repository returning it as T
        return MainViewModel(pokeRepository) as T
    }
}