package com.indioalba.moviesapp.data

import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesService {

    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMovies(
        @Query("region") region: String
    ): MoviesResultDto
}