package com.sonu.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sonu.basiccompose.instgram_home_feed.HomeFeedScreen
import com.sonu.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                HomeFeedScreen()
//                InstagramLogo()
//                FinanceAppProfileDesign()
//                FinanceAppSalesScreen()
            }
        }
    }
}