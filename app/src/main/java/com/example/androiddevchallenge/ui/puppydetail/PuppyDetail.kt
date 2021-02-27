package com.example.androiddevchallenge.ui.puppydetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Male
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.LegoPuppyTheme
import com.example.androiddevchallenge.util.PreviewSurface
import com.example.androiddevchallenge.util.breed
import com.example.androiddevchallenge.util.gender
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@ExperimentalStdlibApi
@Composable
fun PuppyDetail(
    modifier: Modifier = Modifier,
    puppy: Puppy,
    upPress: () -> Unit = {}
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxHeight()
    ) {
        Box(modifier) {
            LazyColumn {
                item {
                    PuppyPhotos(
                        Modifier.fillMaxWidth(),
                        photoList = puppy.puppyPhotoUrlList
                    )
                }

                item {
                    Text(
                        text = puppy.name,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        color = MaterialTheme.colors.onSurface
                    )
                }

                item {
                    PuppyLocation(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        location = "${puppy.location} (${puppy.kmsAway} kms away)"
                    )
                }

                item {
                    LazyRow(
                        contentPadding = PaddingValues(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        item {
                            PuppyProp(
                                imageVector = Icons.Rounded.Pets,
                                propName = puppy.breed,
                                iconTint = MaterialTheme.colors.breed
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }

                        item {
                            PuppyProp(
                                imageVector = when (puppy.gender) {
                                    Puppy.Gender.Boi -> Icons.Rounded.Male
                                    Puppy.Gender.Gurl -> Icons.Rounded.Female
                                },
                                propName = "${puppy.gender}, ${puppy.age} years old",
                                iconTint = MaterialTheme.colors.gender
                            )
                        }
                    }
                }

                item {
                    PuppyBio(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 16.dp, end = 16.dp),
                        bio = puppy.bio,
                    )
                }
            }

            FloatingActionButton(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .statusBarsPadding()
                    .size(48.dp),
                onClick = {
                    upPress()
                },
                backgroundColor = MaterialTheme.colors.background
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onBackground
                )
            }

            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .navigationBarsPadding()
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    Text(
                        "Adopt Me".uppercase(),
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyDetailPreview() {
    PreviewSurface {
        PuppyDetail(Modifier.fillMaxHeight(), Puppy())
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PuppyDetailPreviewDark() {
    PreviewSurface(darkTheme = true) {
        PuppyDetail(Modifier.fillMaxHeight(), Puppy())
    }
}