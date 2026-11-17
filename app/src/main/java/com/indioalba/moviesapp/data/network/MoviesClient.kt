package com.indioalba.moviesapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    var service: MoviesService = retrofit.create(MoviesService::class.java)

}