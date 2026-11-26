package com.indioalba.moviesapp.data

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val poster: String
)

val movies = (1..20).map { i ->
    Movie(
        id = i,
        title = "Movie $i",
        description = "Description Movie $i. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        poster = "https://picsum.photos/200/300?id=$i"
    )
}