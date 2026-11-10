package com.indioalba.moviesapp

data class Movie(
    val id: Int,
    val title: String,
    val poster: String
)

val movies = (1..20).map { i ->
    Movie(
        id = i,
        title = "Movie $i",
        poster = "https://picsum.photos/200/300?id=$i"
    )
}