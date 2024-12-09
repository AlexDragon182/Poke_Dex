package com.example.pokedex.Retrofit.API



import retrofit2.http.GET
import retrofit2.http.Query
import com.example.pokedex.Retrofit.Models.PokemonResponse
import retrofit2.Response
import retrofit2.http.Path

interface PokemonAPI {
        @GET("v2/pokemon-species")
        suspend fun searchPokemon(
            @Query("q")
            pokemonQuery: String,
            @Query("page")
            pokemonPage:Int =  1
        ): Response<PokemonResponse>

        @GET("v2/pokemon-species")
        suspend fun getPokemon(
            @Query("page")
            pokemonPage:Int =  1
        ): Response<PokemonResponse>

        @GET("v2/pokemon-species")
        suspend fun getDetail(
            @Path("Id")
            PokemonId:Int
        ):Response<PokemonResponse>
    }
