package com.indioalba.moviesapp.data

import com.indioalba.moviesapp.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MoviesRepository {

    suspend fun fetchPopularMovies(): List<Movie> = withContext(Dispatchers.IO) {
        MoviesClient.service.listPopularMovies("US")
            .results
            .map { it.toDomainMovie() }
    }
}

private fun MovieDto.toDomainMovie(): Movie = Movie(
    id = id,
    title = title,
    description = overview,
    poster = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" } ?: ""
)