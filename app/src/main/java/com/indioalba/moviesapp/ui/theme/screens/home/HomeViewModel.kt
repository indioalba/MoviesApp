package com.indioalba.moviesapp.ui.theme.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.indioalba.moviesapp.Movie
import com.indioalba.moviesapp.movies
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            delay(3000)
            state = UiState(movies = movies)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
        val movies: List<Movie> = emptyList()
    )
}