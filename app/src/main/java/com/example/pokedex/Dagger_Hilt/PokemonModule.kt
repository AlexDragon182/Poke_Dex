package com.example.pokedex.Dagger_Hilt

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.pokedex.Room.PokemonDatabase
import com.example.pokedex.Util.Constants.Companion.POKEMON_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokemonModule{
    @Singleton
    @Provides
    fun providePokemonDatabase(
        @ApplicationContext app:Context
    )= Room.databaseBuilder(
        app,
        PokemonDatabase::class.java,
        POKEMON_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun providePokemonDao(db:PokemonDatabase) = db.getPokemonDAO()


}


