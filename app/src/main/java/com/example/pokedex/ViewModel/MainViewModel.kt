package com.example.pokedex.ViewModel

import androidx.lifecycle.ViewModel
import com.example.pokedex.ViewModel.Repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel(){


}