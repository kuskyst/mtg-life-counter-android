package jp.kuskyst.mtg_life_counter_android.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.kuskyst.mtg_life_counter_android.ui.LifeCounter
import jp.kuskyst.mtg_life_counter_android.viewmodel.LifeViewModel

@AndroidEntryPoint
class LifeCounterActivity : ComponentActivity() {

    private val viewModel: LifeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel.getLife()
        this.viewModel.life.observe(this) {
            setContent {
                LifeCounter(this.viewModel)
            }
        }
    }
}
