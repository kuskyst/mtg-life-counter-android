package jp.kuskyst.mtg_life_counter_android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun Counter(vararg listener: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.White.copy(alpha = 0.1F))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.1F))
                .weight(1f)
        ) {
            Button(
                onClick = listener[0],
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White.copy(alpha = 0.1F)),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .semantics { contentDescription = "left up" }
            ) {}
            Button(
                onClick = listener[1],
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White.copy(alpha = 0.1F)),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .semantics { contentDescription = "left down" }
            ) {}
        }
        Column(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.1F))
                .weight(1f)
        ) {
            Button(
                onClick = listener[2],
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black.copy(alpha = 0.1F)),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .semantics { contentDescription = "right up" }
            ) {}
            Button(
                onClick = listener[3],
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black.copy(alpha = 0.1F)),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .semantics { contentDescription = "right down" }
            ) {}
        }
    }
}