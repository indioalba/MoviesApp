package com.indioalba.moviesapp.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.indioalba.moviesapp.R
import com.indioalba.moviesapp.data.Movie
import com.indioalba.moviesapp.ui.screens.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    vm: HomeViewModel = viewModel()
) {
    val state = vm.state
    Screen {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.app_name)) },
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
            LazyVerticalGrid(
                modifier = Modifier.padding(innerPadding),
                columns = GridCells.Adaptive(120.dp)
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
fun MovieItem(movie: Movie) {
    Column {
        AsyncImage(
            model = movie.poster,
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
                .aspectRatio(2 / 3f)
        )
        Text(
            text = movie.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
