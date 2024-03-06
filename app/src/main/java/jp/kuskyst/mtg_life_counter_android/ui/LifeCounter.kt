package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import jp.kuskyst.mtg_life_counter_android.Life
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import jp.kuskyst.mtg_life_counter_android.viewmodel.LifeViewModel

@Composable
fun LifeCounter(vm: LifeViewModel) {
    var left = remember {
        mutableStateOf(vm.life.value?.left ?: 20)
    }
    var right = remember {
        mutableStateOf(vm.life.value?.right ?: 20)
    }
    Life(leftLife = left.value, rightLife = right.value)
    Counter(
        {
            left.value += 1
            vm.saveLife(LifeEntity(date = "1", left = left.value, right = right.value))
        },
        {
            if(left.value > 0) left.value -= 1
            vm.saveLife(LifeEntity(date = "1", left = left.value, right = right.value))
        },
        {
            right.value += 1
            vm.saveLife(LifeEntity(date = "1", left = left.value, right = right.value))
        },
        {
            if (right.value > 0) right.value -= 1
            vm.saveLife(LifeEntity(date = "1", left = left.value, right = right.value))
        }
    )
}
