package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.runtime.Composable
import jp.kuskyst.mtg_life_counter_android.Life
import jp.kuskyst.mtg_life_counter_android.model.entity.LifeEntity
import jp.kuskyst.mtg_life_counter_android.viewmodel.LifeViewModel
import java.time.LocalDate

@Composable
fun LifeCounter(vm: LifeViewModel) {
    val now = LocalDate.now().toString()
    Life(leftLife = vm.life.value!!.left, rightLife = vm.life.value!!.right)
    Counter(
        {
            vm.saveLife(LifeEntity(
                date = now,
                left =  vm.life.value!!.left + 1,
                right =  vm.life.value!!.right))
        },
        {
            vm.saveLife(LifeEntity(
                date = now,
                left =  if (vm.life.value!!.left > 0) vm.life.value!!.left - 1 else vm.life.value!!.left,
                right =  vm.life.value!!.right))
        },
        {
            vm.saveLife(LifeEntity(
                date = now,
                left =  vm.life.value!!.left,
                right =  vm.life.value!!.right + 1))
        },
        {
            vm.saveLife(LifeEntity(
                date = now,
                left =  vm.life.value!!.left,
                right =  if (vm.life.value!!.right > 0) vm.life.value!!.right - 1 else vm.life.value!!.right))
        }
    )
    ResetButton {
        vm.saveLife(LifeEntity(date = now, left = 20, right = 20))
    }
    Dice()
}
