package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Album()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Album() {
    AllbumComposition(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
}


fun listdrawable(): List<Int> {
    return listOf(R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6)

}

@Composable
fun AllbumComposition(modifier: Modifier) {
    var index by remember {
        mutableStateOf(0)

    }
    if (index == -1){
        index = 5
    } else if(index == 6) {
        index = 0
    }
    var ListDrawable = listdrawable()

    Column(modifier = modifier , horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Album Photo Test")
        Image(painter = painterResource(ListDrawable.get(index)), contentDescription = "D"+index)
        Row (modifier = Modifier, horizontalArrangement = Arrangement.SpaceBetween){
            Button(modifier = Modifier.padding(end = 30.dp),onClick = {index--}) {
                Text(text ="<")
            }
            Button(modifier=Modifier.padding(start = 30.dp),onClick = {index++}) {
            Text(text =">")
        }
        }
    }
}




