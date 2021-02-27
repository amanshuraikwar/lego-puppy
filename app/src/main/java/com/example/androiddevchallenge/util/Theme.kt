/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.util

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.ui.theme.amber200
import com.example.androiddevchallenge.ui.theme.green300
import com.example.androiddevchallenge.ui.theme.green400
import com.example.androiddevchallenge.ui.theme.orange300
import com.example.androiddevchallenge.ui.theme.orange400
import com.example.androiddevchallenge.ui.theme.pink300
import com.example.androiddevchallenge.ui.theme.pink400

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
