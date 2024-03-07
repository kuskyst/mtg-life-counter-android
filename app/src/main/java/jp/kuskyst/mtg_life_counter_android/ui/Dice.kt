package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import jp.kuskyst.mtg_life_counter_android.R

@Composable
fun Dice() {
    val visible = remember { mutableStateOf(false) }
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
            visible.value,
            enter = scaleIn(animationSpec = tween(durationMillis = 500))
                    + fadeIn(animationSpec = tween(durationMillis = 300)),
            exit = scaleOut(animationSpec = tween(durationMillis = 500))
                    + fadeOut(animationSpec = tween(durationMillis = 300)),
        ) {
            Image(
                painter = painterResource(id = res),
                contentDescription = "dice result"
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
                if (!visible.value) result.value = (1..6).random()
                visible.value = !visible.value
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black.copy(alpha = 0.6F)),
            modifier = Modifier.semantics { contentDescription = "dice start" }
        ) {
            Text(
                text = "Dice",
                color = Color.White
            )
        }
    }
}