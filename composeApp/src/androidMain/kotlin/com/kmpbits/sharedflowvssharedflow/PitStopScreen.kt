package com.kmpbits.sharedflowvssharedflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PitStopScreen() {
    val viewModel = viewModel<PitStopViewModel>()
    val lapCount by viewModel.lapCount.collectAsStateWithLifecycle()

    var alertMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        viewModel.pitStopAlert.collect { alert ->
            alertMessage = alert
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lap: $lapCount", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        alertMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(onClick = { viewModel.nextLap() }) {
            Text("Next Lap")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.triggerPitStop("Tyre wear") }) {
            Text("Trigger Pit Stop")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(onClick = { viewModel.reset() }) {
            Text("Reset")
        }
    }
}