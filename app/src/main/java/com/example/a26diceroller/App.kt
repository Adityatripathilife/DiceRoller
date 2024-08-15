package com.example.a26diceroller

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun App(innerPadding: PaddingValues = PaddingValues() )
    {
    var  scoreplayer01 = remember {
        mutableStateOf(value = 0)
    }
    var  scoreplayer02 = remember {
        mutableStateOf(value = 0)
    }
    var isPlayer1turn = remember { mutableStateOf(value = true)
    }
        var currentimag = remember {
            mutableStateOf(1)
        }
     var images = listOf(
         R.drawable.dice_1,
         R.drawable.dice_2 ,
         R.drawable.dice_3 ,
         R.drawable.dice_4 ,
         R.drawable.dice_5 ,
         R.drawable.dice_6 ,
         )

        if (scoreplayer01.value>=10 || scoreplayer02.value>=10)
        {
            Box (
                modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center
                ,
            ) {
                if (scoreplayer01.value > scoreplayer02.value)
                    Text(text = "Player 01 won",fontSize = 34.sp , fontWeight = FontWeight.ExtraBold
                    ,color = Color.Red)
                else
                    Text(text = "Player 02 won",fontSize = 34.sp , fontWeight = FontWeight.ExtraBold
                    ,color = Color.Red)
            }
        }
        else
    Column (

        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.Yellow)
            , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally
    ){
        if(isPlayer1turn.value) {
            Text(text = "Player 01st Turn" , fontSize = 34.sp , fontWeight = FontWeight.ExtraBold)
        }
        else{
            Text(text = "Player 02nd Turn" , fontSize = 34.sp , fontWeight = FontWeight.ExtraBold)
        }
        Image(painter = painterResource(images.get(currentimag.value)-1), contentDescription = null )
        Row {
            Button(onClick = {
                val random = Random.nextInt(6)+1
                currentimag.value=random
                scoreplayer01.value = scoreplayer01.value + random
                isPlayer1turn.value = !isPlayer1turn.value
            },
            enabled = if (isPlayer1turn.value) true else false
                )

            {
                Text(text = "Player 01")
            }
            Button(onClick =

            {


                val random2 = Random.nextInt(6)+1
                currentimag.value = random2
                scoreplayer02.value = scoreplayer02.value + random2

                isPlayer1turn.value = !isPlayer1turn.value
            },
                enabled = if (isPlayer1turn.value) false else true


            ) {

                Text(text = "Player 02")
            }

            }
        }

    }

