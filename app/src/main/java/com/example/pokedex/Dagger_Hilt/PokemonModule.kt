package com.example.pokedex.Dagger_Hilt

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.pokedex.R
import com.example.pokedex.Room.PokemonDAO
import com.example.pokedex.Room.PokemonDatabase
import com.example.pokedex.Util.Constants.Companion.POKEMON_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
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

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(context, PokemonDatabase::class.java, "tribal_db.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: PokemonDatabase): PokemonDAO {
        return database.getPokemonDAO()
    }

    //@Singleton
    //@Provides
    //fun provideGlide(@ApplicationContext context: Context): RequestManager {
        //return Glide.with(context).setDefaultRequestOptions(
            //RequestOptions()
                //.placeholder(R.drawable.ic_baseline_image_24)
                //.error(R.drawable.ic_baseline_image_24)
        //)
    //}

    //@ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}




