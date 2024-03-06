package jp.kuskyst.mtg_life_counter_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import jp.kuskyst.mtg_life_counter_android.ui.theme.Purple200
import jp.kuskyst.mtg_life_counter_android.ui.theme.Purple700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            life(leftLife = 20, rightLife = 20)
        }
    }
}

@Preview
@Composable
fun life(leftLife: Int, rightLife: Int) {
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
                color = Purple200,
                textAlign = TextAlign.Center,
                fontSize = 200.sp,
                modifier = Modifier.weight(weight = 1f),
            )
            Text(
                text = rightLife.toString(),
                color = Purple700,
                textAlign = TextAlign.Center,
                fontSize = 200.sp,
                modifier = Modifier.weight(weight = 1f),
            )
        }
    }
}
