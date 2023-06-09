package com.sonu.basiccompose.instgram_home_feed

import androidx.compose.ui.graphics.painter.Painter

data class User(
    val profilePic: Painter,
    val username: String,
    val location: String,
    val postPic: Painter,
    val likeCount: Int,
    val caption: String,
    val commentCount: Int
)
