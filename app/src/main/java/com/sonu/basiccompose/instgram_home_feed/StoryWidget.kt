package com.sonu.basiccompose.instgram_home_feed

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sonu.basiccompose.R

@Composable
fun StoryWidget(
    user: User
) {
    val colorList = listOf(Color.Yellow, Color.Red, Color.Magenta)
    val storiesFont = FontFamily(Font(R.font.robotocondensed))
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier.padding(10.dp)
    ) {

        Canvas(modifier = Modifier.size(80.dp)) {
            drawCircle(
                brush = Brush.linearGradient(colors = colorList),
                style = Stroke(
                    width = 15f
                )
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color.White,
                        shape = CircleShape
                    ),
                painter = user.postPic,
                contentDescription = user.caption,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = user.username,
                fontFamily = storiesFont,
                color = Color.DarkGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoryWidgetPrev() {
    StoryWidget(
        User(
            profilePic = painterResource(R.drawable.robb_stark_post),
            username = "queen_daenerys",
            location = "Accra, Ghana",
            postPic = painterResource(R.drawable.robb_stark_post),
            likeCount = 168,
            caption = "Hey Guy's, checkout my new post",
            commentCount = 15
        )
    )
}