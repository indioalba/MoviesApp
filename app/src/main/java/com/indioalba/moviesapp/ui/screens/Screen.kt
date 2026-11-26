package com.indioalba.moviesapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.indioalba.moviesapp.ui.theme.MoviesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(content: @Composable () -> Unit) {
    MoviesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}