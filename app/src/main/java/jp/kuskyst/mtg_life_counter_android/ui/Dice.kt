package jp.kuskyst.mtg_life_counter_android.ui

import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import jp.kuskyst.mtg_life_counter_android.R

@Composable
fun Dice() {
    var visible by remember { mutableStateOf(false) }
    val result = remember { mutableStateOf(1) }
    val res = when(result.value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible,
            enter = scaleIn(animationSpec = tween(durationMillis = 500)),
            exit = scaleOut(animationSpec = tween(durationMillis = 500))
        ) {
            Image(
                painter = painterResource(id = res),
                contentDescription = result.toString()
            )
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                result.value = (1..6).random()
                visible = !visible
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black.copy(alpha = 0.6F)),
        ) {
            Text(
                text = "Dice",
                color = Color.White
            )
        }
    }
}