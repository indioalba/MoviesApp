package com.indioalba.moviesapp.ui.screens.exam

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ManageSearch
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.indioalba.moviesapp.R
import com.indioalba.moviesapp.data.Movie
import com.indioalba.moviesapp.data.movies
import com.indioalba.moviesapp.ui.screens.Screen
import com.indioalba.moviesapp.ui.screens.home.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamScreen() {
    val state = HomeViewModel.UiState(
        movies = movies,
    )
    Screen {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Navigate Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ManageSearch,
                                contentDescription = "share"
                            )
                        }
                    },
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.asicon),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(text = "MoviesApp")
                        }
                    },

                    scrollBehavior = scrollBehavior
                )

            },
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
        ) { innerPadding ->
            val movies = state.movies

            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(innerPadding),
            ) {
                items(movies.size) { index ->
                    MovieItem(
                        movie = movies[index]
                    )
                }
            }
        }
    }
}


@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .height(150.dp)
    ) {
        AsyncImage(
            model = movie.poster,
            contentDescription = movie.title,
            modifier = Modifier
                .aspectRatio(2 / 3f)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = movie.title,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = movie.description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }

    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 1600)
@Composable
fun ExamScreenPreview() {
    ExamScreen()
}
