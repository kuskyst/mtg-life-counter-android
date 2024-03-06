package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import jp.kuskyst.mtg_life_counter_android.Life

@Composable
fun LifeCounter() {
    var left = remember {
        mutableStateOf(20)
    }
    var right = remember {
        mutableStateOf(20)
    }
    Life(leftLife = left.value, rightLife = right.value)
    Counter(
        { left.value += 1 }, { left.value -= 1 },
        { right.value += 1 }, { right.value -= 1 }
    )
}
