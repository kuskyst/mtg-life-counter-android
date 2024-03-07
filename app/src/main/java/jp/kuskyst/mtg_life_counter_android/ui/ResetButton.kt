package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun ResetButton(listener: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = listener,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black.copy(alpha = 0.6F)),
            modifier = Modifier.semantics { contentDescription = "reset" }
        ) {
            Text(
                text = "Reset",
                color = Color.White
            )
        }
    }
}