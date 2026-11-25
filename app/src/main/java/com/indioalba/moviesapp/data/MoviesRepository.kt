package com.indioalba.moviesapp.data

import com.indioalba.moviesapp.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository {

    // simular el delay aquí, vamos a necesitar que sa suspend
    suspend fun fetchPopularMovies(): List<Movie> = withContext(Dispatchers.IO) {
        MoviesClient.service.listPopularMovies(BuildConfig.TMDB_API_KEY, "US")
            .results
            .map { it.toDomainMovie() }
    }
}

private fun RemoteMovie.toDomainMovie(): Movie = Movie(
    id = id,
    title = title,
    description = overview,
    poster = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" } ?: ""
)