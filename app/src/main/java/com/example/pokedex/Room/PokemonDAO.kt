package com.example.pokedex.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.Retrofit.Models.Pokemon


@Dao
interface PokemonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(pokemon:Pokemon):Long

    @Query("SELECT * FROM pokemons")
    fun getAllPokemons () : LiveData<List<Pokemon>>

    @Delete
    suspend fun  delePokemon(pokemon: Pokemon)
}