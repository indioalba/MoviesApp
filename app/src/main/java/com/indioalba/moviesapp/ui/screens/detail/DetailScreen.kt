package com.indioalba.moviesapp.ui.screens.detail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.indioalba.moviesapp.R
import com.indioalba.moviesapp.data.movies
import com.indioalba.moviesapp.ui.screens.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    val movie = movies[0]
    Screen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = movie.title) },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Navigate Back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                AsyncImage(
                    model = movie.poster,
                    contentDescription = movie.title,
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop,
                    onError = { Log.e("Coil", "Image load failed - " + "" + it.result.throwable) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16/9f)
                )
                Text(
                    text = "Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet. Description of the movie lorem ipsum dolor sit amet .Description of the movie lorem ipsum dolor sit amet.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}