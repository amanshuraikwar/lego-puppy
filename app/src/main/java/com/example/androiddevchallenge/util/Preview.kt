package com.example.androiddevchallenge.util

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme

@Composable
fun PreviewSurface(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    LegoPuppyTheme(darkTheme) {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}