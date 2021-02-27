package com.example.androiddevchallenge.util

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.*

val Colors.onSurfaceSecondary: Color
    get() = onSurface.copy(alpha = 0.7f)

val Colors.gender: Color
    get() = if (isLight) pink400 else pink300

val Colors.breed: Color
    get() = if (isLight) orange400 else orange300

val Colors.location: Color
    get() = if (isLight) green400 else green300

val Colors.photoSelected: Color
    get() = amber200

