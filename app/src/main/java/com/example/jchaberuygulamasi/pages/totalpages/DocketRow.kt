package com.example.jchaberuygulamasi.pages.totalpages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jchaberuygulamasi.viewmodel.DocketViewModel
import com.example.jchaberuygulamasi.viewmodel.LastMinuteViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DocketRow(navController: NavController){
    val viewModel: DocketViewModel = hiltViewModel()
    var newsList = viewModel.docketList.observeAsState(listOf())

    Column(modifier = Modifier.size(420.dp,350.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp,0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "Gündem", fontSize = 30.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(120.dp))
            Icon(painter = painterResource(id =com.example.jchaberuygulamasi.R.drawable.baseline_arrow_forward_35) , contentDescription = "")
        }
        LazyRow{

            items(
                count = newsList.value!!.count(),
                itemContent ={
                    val new = newsList.value!![it]

                    Card(modifier = Modifier
                        .size(390.dp, 330.dp)
                        .padding(10.dp, 5.dp),
                        border = BorderStroke(1.dp, Color.LightGray),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Row(modifier = Modifier.clickable {
                    navController.navigate("docket_news")
                        }) {
                            Column(verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(horizontal = 0.dp, vertical = 5.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(text = new.title, fontSize = 19.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
                                Spacer(modifier = Modifier.height(5.dp))
                                GlideImage(imageModel = new.urlToImage,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(15.dp)))

                            }
                        }

                    }
                }
            )

        }
    }
}
