package com.indioalba.moviesapp.data

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class MoviesRepository {

    suspend fun fetchPopularMovies(): List<Movie> {
        delay(3000.milliseconds)
        return movies
    }
}