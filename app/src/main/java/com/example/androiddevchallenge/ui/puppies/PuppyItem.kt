package com.example.androiddevchallenge.ui.puppies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Male
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.util.*
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyItem(modifier: Modifier = Modifier, puppy: Puppy) {
    Row(
        modifier.padding(16.dp),
        verticalAlignment = Alignment.Top
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

        Column(
            Modifier.padding(start = 16.dp)
        ) {
            Text(
                puppy.name,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {

                Icon(
                    imageVector = Icons.Rounded.Pets,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MaterialTheme.colors.breed
                )

                Text(
                    puppy.breed,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    imageVector = when (puppy.gender) {
                        Puppy.Gender.Boi -> Icons.Rounded.Male
                        Puppy.Gender.Gurl -> Icons.Rounded.Female
                    },
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MaterialTheme.colors.gender
                )

                Text(
                    "${puppy.gender}, ${puppy.age} years old",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurfaceSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MaterialTheme.colors.location
                )

                Text(
                    "${puppy.kmsAway} kms away",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurfaceSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PuppyItemPreview() {
    PreviewSurface {
        PuppyItem(
            puppy = Puppy()
        )
    }
}

@Preview
@Composable
fun PuppyItemPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyItem(
            puppy = Puppy()
        )
    }
}