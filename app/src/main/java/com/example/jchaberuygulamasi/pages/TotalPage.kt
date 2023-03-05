package com.example.jchaberuygulamasi.pages


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jchaberuygulamasi.pages.totalpages.*


@Composable
fun TotalPage(navController: NavController){
    LazyColumn {
        item{
            LastMinuteRow(navController)
            WorldRow(navController)
            HeadlineRow(navController)
            DocketRow(navController)
            PoliticRow(navController)
            SportRow(navController)
            HealthRow(navController)
            ScienceRow(navController)
            TechnologyRow(navController)
            LifeRow(navController)
            CultureRow(navController)
            Spacer(modifier = Modifier.height(50.dp))
        }

    }

}

