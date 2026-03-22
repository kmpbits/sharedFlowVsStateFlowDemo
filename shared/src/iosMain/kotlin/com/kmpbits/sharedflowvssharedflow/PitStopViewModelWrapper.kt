package com.kmpbits.sharedflowvssharedflow

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PitStopViewModelWrapper {
    private val viewModel = PitStopViewModel()

    fun observeLapCount(onChange: (Int) -> Unit) {
        viewModel.lapCount
            .onEach(onChange)
            .launchIn(viewModel.viewModelScope)
    }

    fun observePitStopAlert(onAlert: (String) -> Unit) {
        viewModel.pitStopAlert
            .onEach(onAlert)
            .launchIn(viewModel.viewModelScope)
    }

    fun nextLap() {
        viewModel.nextLap()
    }

    fun triggerPitStop(reason: String) {
        viewModel.triggerPitStop(reason)
    }

    fun reset() {
        viewModel.reset()
    }

    fun dispose() {
        viewModel.viewModelScope.cancel()
    }
}