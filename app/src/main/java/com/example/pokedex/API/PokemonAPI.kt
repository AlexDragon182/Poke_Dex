package com.example.pokedex.API

import com.example.pokedex.Response_Object.PokemonResponse
import com.google.android.gms.common.api.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonAPI {
    interface PokemonAPI {
        @GET("v2/pokemon-species")
        suspend fun getPokemon(
            @Query("q")
            SearchQuery:String,
            @Query("page")
            Pokemonpage:Int =  1
        ): Response<PokemonResponse>
}
}