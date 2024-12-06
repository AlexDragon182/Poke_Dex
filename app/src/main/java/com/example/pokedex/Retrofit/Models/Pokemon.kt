package com.example.pokedex.Retrofit.Models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.Util.Constants.Companion.POKEMON_DATABASE_NAME
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = POKEMON_DATABASE_NAME
)
@Parcelize
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val name: String,
    val url: String
) : Parcelable