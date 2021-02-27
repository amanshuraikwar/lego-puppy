package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.PreviewSurface

@Composable
fun PuppyBio(modifier: Modifier = Modifier, bio: String) {
    Text(
        text = bio,
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
}

@Preview
@Composable
fun PuppyBioPreview() {
    PreviewSurface {
        PuppyBio(
            bio = Puppy().bio
        )
    }
}

@Preview
@Composable
fun PuppyBioPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyBio(
            bio = Puppy().bio
        )
    }
}