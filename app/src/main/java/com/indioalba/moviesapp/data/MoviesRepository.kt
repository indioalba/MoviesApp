package com.indioalba.moviesapp.data

import com.indioalba.moviesapp.BuildConfig
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class MoviesRepository {

    suspend fun fetchPopularMovies(): List<Movie> {
        val apikey = BuildConfig.TMDB_API_KEY
        delay(3000.milliseconds)
        return movies
    }
}