package com.sonu.basiccompose.instgram_home_feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sonu.basiccompose.R

@Composable
fun BottomBar() {
    BottomAppBar(
        backgroundColor = Color.White
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_home_filled),
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(35.dp),
                    tint = Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Search Icon",
                    modifier = Modifier.size(35.dp),
                    tint = Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_reels_outline),
                    contentDescription = "Reels Icon",
                    modifier = Modifier.size(35.dp),
                    tint = Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_like_outline),
                    contentDescription = "Like Icon",
                    modifier = Modifier.size(35.dp),
                    tint = Color.Black
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Image(
                    painter = painterResource(R.drawable.jon_snow),
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp)
                )
            }
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar()
}