package com.example.moviesassesment.presentation.movies_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesassesment.common.Resource
import com.example.moviesassesment.domain.use_cases.get_movies.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state


    init {
        getMovies()
    }

    private fun getMovies() {
        getMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MovieListState(movies = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = MovieListState(error = result.message ?: "Some thing went wrong")
                }

                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}