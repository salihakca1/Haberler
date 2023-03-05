package com.example.jchaberuygulamasi

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jchaberuygulamasi.pages.*
import com.example.jchaberuygulamasi.ui.theme.JCHaberUygulamasiTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCHaberUygulamasiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TransitionsPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage(navController: NavController){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    var secilenItem = remember { mutableStateOf(0) }

    val gradientColors = listOf(Color.LightGray, Color.LightGray,  Color.White, Color.White, Color.LightGray, Color.White, Color.LightGray, Color.LightGray)

    Scaffold(
        scaffoldState = scaffoldState,
        topBar ={
        TopAppBar(
                  title = { Text(text = "HABERLER", fontSize = 47.sp, fontWeight = FontWeight.ExtraBold,
                      style = TextStyle(
                          brush = Brush.linearGradient(
                              colors = gradientColors
                          )
                      ),
                      textAlign = TextAlign.Center)},
                    navigationIcon ={
                        Icon(painter = painterResource(id =R.drawable.baseline_dehaze_40), contentDescription = "",
                        modifier = Modifier.clickable {
                            scope.launch {
                                scaffoldState.drawerState.open() //tıklanınca oraya açılacak
                            }
                        })
                    },
                  backgroundColor = colorResource(id = R.color.anaRenk),
                  contentColor = Color.White)
        },
        content =   {
            if (secilenItem.value == 0){
                TotalPage(navController = navController)
            }
            if (secilenItem.value == 1){
                LastMinuteNews()
            }
            if (secilenItem.value == 2){
                WorldNews()
            }
            if (secilenItem.value == 3){
                DocketNews()
            }
            if (secilenItem.value == 4){
                LastMinuteNews()
            }
            if (secilenItem.value == 5){
                WorldNews()
            }
            if (secilenItem.value == 6){
                HeadlineNews()
            }
            if (secilenItem.value == 9){
                PoliticNews()
            }

            if (secilenItem.value == 11){
                SportNews()
            }
            if (secilenItem.value == 12){
                HealthNews()
            }
            if (secilenItem.value == 13){
                ScienceNews()
            }
            if (secilenItem.value == 14){
                TechnologyNews()
            }
            if (secilenItem.value == 15){
                LifeNews()
            }
            if (secilenItem.value == 16){
                CultureNews()
            }

        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = colorResource(id = R.color.anaRenk),
                content = {
                    BottomNavigation(backgroundColor = colorResource(id = R.color.anaRenk)) {

                    BottomNavigationItem(selected = secilenItem.value == 0, onClick = {secilenItem.value = 0},
                        icon = {
                                Icon(painter = painterResource(id = R.drawable.baseline_home_32), contentDescription = "")
                        },
                        label ={ Text(text = "Anasayfa", fontSize = 15.sp)},
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.White
                        )
                        BottomNavigationItem(selected = secilenItem.value == 1, onClick = {secilenItem.value = 1},
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.baseline_bolt_last_minute), contentDescription = "")
                            },
                            label ={ Text(text = "Son-Dakika", fontSize = 15.sp)},
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color.White
                        )
                        BottomNavigationItem(selected = secilenItem.value == 2, onClick = {secilenItem.value = 2},
                            icon = {
                                Icon(painter = painterResource(id = R.drawable.baseline_public_24_world), contentDescription = "")
                            },
                            label ={ Text(text = "Dünya", fontSize = 15.sp)},
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color.White
                        )

                    }
                }
            )
        },
        drawerContent = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .size(30.dp)
                .background(colorResource(id = R.color.anaRenk))) {

            }

            DropdownMenuItem(onClick = {
                    secilenItem.value = 4
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .size(350.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_bolt_last_minute), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Son-Dakika", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 5
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(350.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp)
                        .size(400.dp, 60.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_public_24_world), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Dünya", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 6
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_tour_docket), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Manşet", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 3
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_star_24), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Gündem", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }

            DropdownMenuItem(onClick = {
                secilenItem.value = 9
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_published_with_changes_politic), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Siyaset", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }

            DropdownMenuItem(onClick = {
                secilenItem.value = 11
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_sports_basketball_24), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Spor", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 12
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_health_and_safety_24), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Sağlık", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 13
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_science_24), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Bilim", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 14
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_timeline_tech), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Teknoloji", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 15
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_local_fire_department_life), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Yaşam", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 16
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }) {
                Card(modifier = Modifier
                    .padding(0.dp, 3.dp)
                    .fillMaxWidth()
                    .size(400.dp, 58.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_terrain_culture), contentDescription ="" )
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Kültür", fontSize = 22.sp, color = Color.Black, fontStyle = FontStyle.Italic)
                    }
                }
            }
        }
    )

    val activity = (LocalContext.current as Activity)

    BackHandler(onBack = {
        if (scaffoldState.drawerState.isOpen){
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }else{
            activity.finish()
        }
    })

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JCHaberUygulamasiTheme {

    }
}