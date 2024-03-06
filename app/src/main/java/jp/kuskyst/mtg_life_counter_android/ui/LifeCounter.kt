package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import jp.kuskyst.mtg_life_counter_android.Life
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import jp.kuskyst.mtg_life_counter_android.viewmodel.LifeViewModel
import java.time.LocalDate

@Composable
fun LifeCounter(vm: LifeViewModel) {
    val now = mutableStateOf(LocalDate.now().toString())
    Life(leftLife = vm.life.value!!.left, rightLife = vm.life.value!!.right)
    Counter(
        {
            vm.saveLife(LifeEntity(
                date = now.value,
                left =  vm.life.value!!.left + 1,
                right =  vm.life.value!!.right))
        },
        {
            vm.saveLife(LifeEntity(
                date = now.value,
                left =  vm.life.value!!.left - 1,
                right =  vm.life.value!!.right))
        },
        {
            vm.saveLife(LifeEntity(
                date = now.value,
                left =  vm.life.value!!.left,
                right =  vm.life.value!!.right + 1))
        },
        {
            vm.saveLife(LifeEntity(
                date = now.value,
                left =  vm.life.value!!.left,
                right =  vm.life.value!!.right - 1))
        }
    )
    ResetButton {
        vm.saveLife(LifeEntity(date = now.value, left = 20, right = 20))
    }
}
