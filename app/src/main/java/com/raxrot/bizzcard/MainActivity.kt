package com.raxrot.bizzcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val buttonClickedState = remember { mutableStateOf(false) }

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
               .height(400.dp)
               .fillMaxWidth()
               .padding(top = 30.dp)
               .background(Color.Cyan),
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally) {

               CreateImageProfile()

               Divider(color = Color.Black,
                   thickness =1.dp)

               CreateInfo()

               ShowButton(buttonClickedState)
           }

           if (buttonClickedState.value) {
               Content()
           }

       }

   }
}

@Composable
private fun ShowButton(buttonClickedState: MutableState<Boolean>) {

    Button(
        onClick = { buttonClickedState.value=!buttonClickedState.value},
        modifier = Modifier.padding(top = 15.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(
            text = if (buttonClickedState.value) "Hide" else "Show",
            fontSize = 25.sp,
            modifier = Modifier.padding(3.dp)
        )
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
            text = "Future Android Developer",
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
fun Content() {
    val projects = listOf("Project1", "Project2", "Project3", "Project4", "Project5", "Project6")
    val images = listOf(
        R.drawable.cat,
        R.drawable.av,
        R.drawable.cat,
        R.drawable.av,
        R.drawable.cat
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            border = BorderStroke(width = 2.dp, color = Color.Green)
        ) {
            Portfolio(data = projects,images=images)
        }
    }
}

@Composable
fun Portfolio(data: List<String>, images: List<Int>) {
    val projectWithImages = data.zip(images) //create pair data with images

    LazyColumn {
        items(projectWithImages) { (project, image) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.LightGray)
                    .height(100.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(85.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(text = project, fontSize = 20.sp)
            }
        }
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



