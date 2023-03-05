package com.example.jchaberuygulamasi.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jchaberuygulamasi.viewmodel.LastMinuteViewModel
import com.example.jchaberuygulamasi.viewmodel.TechnologyViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun TechnologyNews(){

    val viewModel: TechnologyViewModel = hiltViewModel()
    var newsList = viewModel.technologyList.observeAsState(listOf())


    LazyColumn{
        items(
            count = newsList.value!!.count(),
            itemContent ={
                val new = newsList.value!![it]

                Card(modifier = Modifier
                    .padding(5.dp, 5.dp)
                    .fillMaxWidth(),
                    border = BorderStroke(1.dp,Color.LightGray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(modifier = Modifier.clickable {

                    }) {
                        Column(verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(horizontal = 0.dp, vertical =  5.dp)
                                .fillMaxWidth()
                        ) {
                            Text(text = new.title, fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.height(10.dp))
                            GlideImage(imageModel = new.urlToImage,
                                modifier = Modifier
                                    .size(393.dp, 250.dp)
                                    .fillMaxSize().clip(RoundedCornerShape(15.dp)))
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = new.description, fontSize = 19.sp, color = Color.Black, fontStyle = FontStyle.Italic, textAlign = TextAlign.Center)
                            Spacer(modifier = Modifier.height(17.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(all = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = new.author, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                                Text(text = new.publishedAt, fontSize = 17.sp)
                            }
                        }
                    }

                }
            }
        )

    }
}