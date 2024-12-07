package com.example.pokedex.ViewModel.Repositories

import com.example.pokedex.Retrofit.Models.Pokemon
import com.example.pokedex.Retrofit.retrofitInstance
import com.example.pokedex.Room.PokemonDAO
import retrofit2.http.Query
import javax.inject.Inject

class MainRepository @Inject constructor(
    val pokemonDAO: PokemonDAO
){

    suspend fun  deletePokemon(pokemon: Pokemon) = pokemonDAO.deletePokemon(pokemon)

    suspend fun upsert(pokemon: Pokemon) = pokemonDAO.upsert(pokemon)

    suspend fun getPokemon(pokemonQuery:String,pokemonPage:Int) = retrofitInstance.api.getPokemon(pokemonQuery,pokemonPage)

    suspend fun getDetail (pokemonId:Int) = retrofitInstance.api.getDetail(pokemonId)
}