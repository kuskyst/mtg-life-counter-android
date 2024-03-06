package jp.kuskyst.mtg_life_counter_android.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import jp.kuskyst.mtg_life_counter_android.Life

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Life(leftLife = 20, rightLife = 20)
        }
    }
}
