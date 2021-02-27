package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.PreviewSurface
import com.example.androiddevchallenge.util.location
import com.example.androiddevchallenge.util.onSurfaceSecondary

@Composable
fun PuppyLocation(modifier: Modifier = Modifier, location: String) {
    Row(
        modifier,
        verticalAlignment = Alignment.Bottom
    ) {
        Icon(
            imageVector = Icons.Rounded.LocationOn,
            contentDescription = null,
            tint = MaterialTheme.colors.location,
            modifier = Modifier.size(20.dp)
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = location,
            style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colors.onSurfaceSecondary,
        )
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyLocationPreview() {
    PreviewSurface {
        PuppyLocation(location = Puppy().location)
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyLocationPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyLocation(location = Puppy().location)
    }
}