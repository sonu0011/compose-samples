package com.sonu.basiccompose.instgram_home_feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonu.basiccompose.R

@Composable
fun PostWidget(
    user: User
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp),
                    painter = user.profilePic,
                    contentDescription = stringResource(id = R.string.profile_pic)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = user.username,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = user.location,
                        fontSize = 14.sp
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_more),
                    contentDescription = stringResource(
                        id = R.string.more
                    )
                )
            }
        }

        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = user.postPic,
            contentDescription = stringResource(id = R.string.post_pic)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_like_outline),
                        contentDescription = "Like Icon",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_comment),
                        contentDescription = "Like Icon",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_send),
                        contentDescription = "Like Icon",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.ic_save),
                    contentDescription = "Like Icon",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                text = "${user.likeCount} likes"
            )
            Text(
                text = buildAnnotatedString {
                    append(
                        AnnotatedString(
                            text = "${user.username}  ",
                            spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
                        )
                    )
                    append(user.caption)
                }
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "View all ${user.commentCount} comments",
                color = Color.DarkGray,
                fontSize = 13.sp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PostWidgetPrev() {
    PostWidget(
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