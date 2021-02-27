package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyPhotos(
    modifier: Modifier = Modifier,
    photoList: List<String>
) {
    var selectedImageIndex by remember { mutableStateOf(0) }
    Box(
        modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        CoilImage(
            data = photoList[selectedImageIndex],
            contentDescription = null,
            fadeIn = true,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(MaterialTheme.colors.background)
        )

        LazyRow(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.background
                        )
                    )
                )
        ) {
            itemsIndexed(photoList) { index, item ->
                if (index > 0) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
                CoilImage(
                    data = item,
                    contentDescription = null,
                    fadeIn = true,
                    contentScale = ContentScale.Crop,
                    modifier = if (index == selectedImageIndex) {
                        Modifier
                            .size(72.dp)
                            .border(
                                width = 4.dp,
                                MaterialTheme.colors.background,
                                shape = RoundedCornerShape(28)
                            )
                            .clip(MaterialTheme.shapes.medium)
                    } else {
                        Modifier
                            .size(72.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .clickable(onClick = { selectedImageIndex = index })
                    }
                )
            }
        }
    }
}