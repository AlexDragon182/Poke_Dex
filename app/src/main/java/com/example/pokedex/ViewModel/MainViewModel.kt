package com.example.pokedex.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.Retrofit.Models.PokemonResponse
import com.example.pokedex.ViewModel.Repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel

data class ErrorResponse(
    val message: String = "",
    val code: Int? = null
)

sealed class ViewState<out T : Any>
class Success<out T : Any>(val data: Any? = null) : ViewState<T>()
class Error<out T : Any>(val code: Int? = null, val errorResponse: ErrorResponse? = null) : ViewState<T>()
class Loading<out T : Any> (val data: Any? = null): ViewState<T>()

sealed class Resource<T>(var data : T? = null, var code : Int? = null, var errorResponse: ErrorResponse? = null){
    class Success<T>(data: T? = null) : Resource<T>(data = data)
    class Error<T>(code: Int? = null,  errorResponse: ErrorResponse? = null) : Resource<T>(code= code, errorResponse = errorResponse)
    class Loading<T> : Resource<T>()
}

class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel(){
fun getPokemon() =
    viewModelScope.launch {

    }
val getPokemon : MutableLiveData <Resource<PokemonResponse>> = MutableLiveData()
    var pokemonPage = 1

    fun getPokemon(pokemonPage : Int) = viewModelScope.launch {
        getPokemon.postValue(Resource.Loading())
        val response = mainRepository.getPokemon(pokemonPage)
    }


    private fun handlePagination (response : Response<PokemonResponse>) : Resource <PokemonResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error()
    }


}