package jp.kuskyst.mtg_life_counter_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Life(leftLife: Int, rightLife: Int) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            Text(
                text = leftLife.toString(),
                color = LeftCountColor,
                textAlign = TextAlign.Center,
                fontSize = 200.sp,
                modifier = Modifier.weight(weight = 1f),
            )
            Text(
                text = rightLife.toString(),
                color = RightCountColor,
                textAlign = TextAlign.Center,
                fontSize = 200.sp,
                modifier = Modifier.weight(weight = 1f),
            )
        }
    }
}
