package com.example.jchaberuygulamasi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jchaberuygulamasi.pages.*

@Composable
fun TransitionsPage(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen"){
        composable("splash_screen"){
            SplashPage(navController)
        }
        composable("main_page"){
            MainPage(navController)
        }
        composable("last_minute_news"){
            LastMinuteNews()
        }
        composable("culture_news"){
            CultureNews()
        }
        composable("docket_news"){
            DocketNews()
        }
        composable("headline_news"){
            HeadlineNews()
        }
        composable("health_news"){
            HealthNews()
        }
        composable("life_news"){
            LifeNews()
        }
        composable("politic_news"){
            PoliticNews()
        }
        composable("science_news"){
            ScienceNews()
        }
        composable("sport_news"){
            SportNews()
        }
        composable("technology_news"){
            TechnologyNews()
        }
        composable("world_news"){
            WorldNews()
        }
    }
}