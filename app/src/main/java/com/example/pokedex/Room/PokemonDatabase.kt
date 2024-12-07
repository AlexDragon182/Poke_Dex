package com.example.pokedex.Room

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.pokedex.Retrofit.Models.Pokemon

@Database(// for room always need to be abstract
    entities = [Pokemon::class],
    version = 1

)

//@TypeConverters(Converters::class)

abstract class PokemonDatabase : RoomDatabase() {

    abstract fun getPokemonDAO(): PokemonDAO

    companion object{
        @Volatile // other threds can see when this instance changes
        private var instance: PokemonDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: createDatabase (context).also { instance = it}

        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PokemonDatabase::class.java,
                "pokemon_db.db"
            ).build()
    }
}