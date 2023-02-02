package com.example.myownapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myownapp.ui.theme.MyOwnAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Cyan),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column {
                    var i by rememberSaveable { mutableStateOf("") }
                    var n by rememberSaveable { mutableStateOf("") }
                    val infiniteTransition= rememberInfiniteTransition()
                    val angle: Float by infiniteTransition.animateFloat(
                        initialValue = 0f,
                        targetValue =360f,
                        animationSpec = infiniteRepeatable(
                                animation = keyframes {
                                    durationMillis = 1000
                                }
                                )
                    )


                    //lfjkfd
                    Image(painterResource(id = android.R.drawable.star_big_on)  ,
                        contentDescription = "",
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .rotate(angle))
                    Image(painterResource(id = R.drawable.andr), contentDescription = "",Modifier
                        //.rotate(angle)
                        .align(Alignment.CenterHorizontally))
                    Text(text = "Username", fontSize = 30.sp, color = Color.Red)
                    TextField(value = i, onValueChange = { i = it })
                    Text(text = "Password", fontSize = 30.sp, color = Color.Red)
                    TextField(value = n, onValueChange = { n = it })

                    Row() {


                        Button(onClick = {
                            Toast.makeText(
                                applicationContext,
                                "Welcome " + i,
                                Toast.LENGTH_LONG
                            ).show()
                        }) {
                            Text(text = "SIGNIN")
                        }


                        Button(onClick = {
                            var ii = Intent(applicationContext, MainActivity2::class.java)
                            ii.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            //ii.putExtra("uname",i)
                            //ii.putExtra("pwd",n)
                            startActivity(ii)
                        }) {
                            Text(text = "SIGNUP")
                        }

                    }

                }
            }
        }
    }

    /*@Composable
    fun Greeting() {
        var s by remember { mutableStateOf("") }
        var s2 by remember { mutableStateOf("") }
    }*/
}


