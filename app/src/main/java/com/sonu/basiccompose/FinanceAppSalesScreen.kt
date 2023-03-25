package com.sonu.basiccompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
fun FinanceAppSalesScreen() {
    val maxSaleNumber = year2023Sales.maxOf { it.salesInThousands }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(CustomDarkGray, CustomLightGreen)
                )
            )
            .padding(25.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    tint = Color.White,
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = stringResource(
                        id = R.string.more
                    )
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
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(40.dp),
                    painter = painterResource(id = R.drawable.david),
                    contentDescription = stringResource(
                        id = R.string.profile_pic
                    )
                )
            }
        }

        LazyRow(
            modifier = Modifier.height(250.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(year2023Sales) { item ->
                SingleBar(monthlySalesData = item, maxSaleNumber)
            }
        }

        Text(
            text = "Sales Revenue",
            modifier = Modifier.padding(vertical = 12.dp),
            fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )

        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                InfoCard(
                    modifier = Modifier.weight(8f),
                    icon = R.drawable.ic_sales,
                    valueText = "230k",
                    subHeading = "Sales"
                )
                Spacer(modifier = Modifier.weight(1f))
                InfoCard(
                    modifier = Modifier.weight(11f),
                    icon = R.drawable.ic_wallet,
                    valueText = "1.423k",
                    subHeading = "Products"
                )
            }

            Spacer(modifier = Modifier.width(20.dp))


            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                InfoCard(
                    modifier = Modifier.weight(10f),
                    icon = R.drawable.ic_user,
                    valueText = "8.549k",
                    subHeading = "Customers"
                )
                Spacer(
                    modifier = Modifier.weight(1f),
                )
                InfoCard(
                    modifier = Modifier.weight(8f),
                    icon = R.drawable.ic_chart,
                    valueText = "$9745",
                    subHeading = "Revenue"
                )
                Spacer(
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
fun InfoCard(
    modifier: Modifier, icon: Int, valueText: String, subHeading: String
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxSize()
            .background(color = Color.White.copy(alpha = 0.1f)), contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = valueText,
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = subHeading,
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontSize = 12.sp,
                color = Color.White
            )
        }

    }

}

@Composable
fun SingleBar(
    monthlySalesData: MonthlySalesData, maxSale: Int
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "${monthlySalesData.salesInThousands}k",
            fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(5.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .width(40.dp)
                .height(
                    (200 * monthlySalesData.salesInThousands / maxSale).dp
                )
                .background(
                    if (year2023Sales.indexOf(monthlySalesData) % 2 == 0) CustomLightOrange else CustomCyan
                )
        ) {

        }
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = monthlySalesData.month,
            fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color.White
        )

    }
}

data class MonthlySalesData(
    val month: String, val salesInThousands: Int
)

val year2023Sales = mutableListOf(
    MonthlySalesData(month = "Jan", salesInThousands = 13),
    MonthlySalesData(month = "Feb", salesInThousands = 24),
    MonthlySalesData(month = "Mar", salesInThousands = 16),
    MonthlySalesData(month = "Apr", salesInThousands = 32),
    MonthlySalesData(month = "May", salesInThousands = 26),
    MonthlySalesData(month = "Jun", salesInThousands = 19),
    MonthlySalesData(month = "Jul", salesInThousands = 12),
    MonthlySalesData(month = "Aug", salesInThousands = 18),
    MonthlySalesData(month = "Sep", salesInThousands = 11),
    MonthlySalesData(month = "Oct", salesInThousands = 21),
    MonthlySalesData(month = "Nov", salesInThousands = 23),
    MonthlySalesData(month = "Dec", salesInThousands = 19),
)

@Preview(showBackground = true)
@Composable
fun FinanceAppSalesScreenPreview() {
    FinanceAppSalesScreen()
}
