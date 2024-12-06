package com.example.pokedex.Room

import androidx.room.TypeConverter
import com.example.pokedex.Retrofit.Models.Color
import okio.Source

class Converter {
    @TypeConverter
    fun fromColor(color: Color) : String{
        return color.name

    }

    fun ToColor(name: String) : Source{
        return Color(name,name)
    }
}