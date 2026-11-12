package com.indioalba.moviesapp.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indioalba.moviesapp.data.Movie
import com.indioalba.moviesapp.data.MoviesRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    private val moviesRepository = MoviesRepository()

    init {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            state = UiState(movies = moviesRepository.fetchPopularMovies())
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
        val movies: List<Movie> = emptyList()
    )
}