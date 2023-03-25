package com.sonu.basiccompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonu.basiccompose.ui.theme.*

@Composable
fun FinanceAppProfileDesign() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(listOf(CustomDarkGray, CustomLightGreen))
            )
            .padding(25.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = stringResource(
                        id = R.string.more
                    ),
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 1.dp, color = CustomOrange, shape = RoundedCornerShape(20f)
                    ), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.david),
                    contentDescription = stringResource(id = R.string.profile_pic),
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(40.dp)
                )
            }
        }

        Column {
            Text(
                text = "Hello David",
                fontSize = 40.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.ubuntu))
            )

            Text(
                text = "Welcome back",
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.ubuntu))
            )
        }
        ProfileInfoCard(
            heading = "Sales",
            subHeading = "Total sales today",
            valueText = "$500",
            percentage = 55,
            color = CustomOrange,
            isIncreasing = true
        )

        ProfileInfoCard(
            heading = "Profit",
            subHeading = "Per day ratio",
            valueText = "$500",
            percentage = 30,
            color = CustomGreen,
            isIncreasing = false
        )


        ProfileInfoCard(
            heading = "Orders",
            subHeading = "Total orders today",
            valueText = "1250",
            percentage = 80,
            color = CustomCyan,
            isIncreasing = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "home",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    painter = painterResource(id = R.drawable.wallet),
                    contentDescription = "wallet",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )

            }


            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.finance),
                    contentDescription = "finance",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )


            }

            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "user",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }

}

@Composable
fun ProfileInfoCard(
    heading: String,
    subHeading: String,
    valueText: String,
    percentage: Int,
    color: Color,
    isIncreasing: Boolean
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .height(140.dp)
            .background(Color.White.copy(alpha = 0.1f))
            .padding(
                start = 30.dp,
                top = 10.dp,
                bottom = 10.dp,
                end = 10.dp
            )
    ) {

        Row(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .weight(7f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    color = Color.White,
                    text = heading,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu))
                )

                Text(
                    color = color,
                    text = subHeading,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu))
                )


                Text(
                    color = color,
                    text = valueText,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.ubuntu))
                )
            }

            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
            ) {
                Icon(
                    tint = color,
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "forward",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .rotate(if (isIncreasing) 45f else -45f),
                )

                Text(
                    color = color,
                    text = "$percentage%",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.ubuntu)),
                    modifier = Modifier.align(Alignment.Center)
                )

                Canvas(
                    modifier = Modifier
                        .size(70.dp)
                        .align(Alignment.Center)
                ) {
                    drawArc(
                        color = color,
                        startAngle = -120f,
                        sweepAngle = 360 * (percentage / 100f),
                        useCenter = false,
                        style = Stroke(
                            width = 10f,
                            cap = StrokeCap.Round
                        )
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProfileInfoCardPreview() {
    // ProfileInfoCard()
}


@Preview(showBackground = true)
@Composable
fun FinanceAppProfileDesignPreview() {
    FinanceAppProfileDesign()
}


