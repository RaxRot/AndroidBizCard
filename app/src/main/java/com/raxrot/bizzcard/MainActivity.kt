package com.raxrot.bizzcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raxrot.bizzcard.ui.theme.BizzCardTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizzCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
   Surface(modifier = Modifier
       .fillMaxWidth()
       .fillMaxHeight()) {

       Card(modifier = Modifier
           .padding(15.dp),
            elevation = CardDefaults.cardElevation(5.dp),
           shape = RoundedCornerShape(corner = CornerSize(15.dp)),
           colors = CardDefaults.cardColors(containerColor = Color.White)
       ){

           Column(modifier = Modifier
               .height(300.dp)
               .fillMaxWidth()
               .padding(top = 30.dp),
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally) {

               CreateImageProfile()
               Divider(color = Color.Black,
                   thickness =1.dp)

               CreateInfo()
           }
       }

   }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Vlad Bulahov", fontSize = 25.sp,
            modifier = Modifier.padding(top = 15.dp),
            color = Color.Blue, fontWeight = FontWeight.Bold
        )
        Text(
            text = "Android Developer",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
        Text(
            text = "dasistperfektos@gmail.com",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.av),
            contentDescription = null, modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun CreateBizCardPreview() {
    CreateBizCard()
}



