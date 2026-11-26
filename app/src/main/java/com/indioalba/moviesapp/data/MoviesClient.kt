package com.indioalba.moviesapp.data

import com.indioalba.moviesapp.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

// 3 Retrofit
object MoviesClient {

    // como pasar la api key, dos formas,
    // o bien en cada peticion se añade el argumento a cada petición
    // o bien con un interceptor,(OKHTTP) que lo añade a todas las peticiones

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(::apiKeyAsQuery)
        .build()

    // Doc
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json; charset=UTF8".toMediaType()))
        .build()

    val service: MoviesService = retrofit.create()
}

private fun apiKeyAsQuery(chain: Interceptor.Chain) = chain.proceed(
    chain
        .request()
        .newBuilder()
        // new request con una nueva url , a la que se añade una nueva query api_key
        .url(
            chain.request().url
                .newBuilder()
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()
        )
        .header("OS", "Android")
        .header("version", BuildConfig.VERSION_NAME)
        .build()
)