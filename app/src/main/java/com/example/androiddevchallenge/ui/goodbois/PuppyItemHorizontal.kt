package com.example.androiddevchallenge.ui.goodbois

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyItemHorizontal(modifier: Modifier = Modifier, puppy: Puppy) {
    Column(modifier) {

        Box(
            contentAlignment = Alignment.BottomStart
        ) {
            CoilImage(
                data = puppy.puppyPhotoUrlList[0],
                contentDescription = null,
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(128.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colors.primary)
            )

            Text(
                text = "Playful Boi",
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 128.dp)
                    .clip(
                        MaterialTheme.shapes.medium.copy(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp)
                        )
                    )
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                    .padding(bottom = 4.dp, top = 4.dp),
                textAlign = TextAlign.Center
            )
        }

        Text(
            puppy.name,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .width(width = 128.dp)
                .padding(top = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun PuppyItemHorizontalPreview() {

}