package com.sonu.basiccompose.instgram_home_feed

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonu.basiccompose.R

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = Color.White,
        elevation = 2.dp,
        title = {
            Text(
                modifier = Modifier.offset(y = 5.dp),
                text = "Instagram",
                fontSize = 35.sp,
                fontFamily = FontFamily(Font(R.font.instagram_logo_font))
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = stringResource(id = R.string.add_icon)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = stringResource(id = R.string.send_message)
                )
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}