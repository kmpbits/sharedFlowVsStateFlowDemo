package com.kmpbits.sharedflowvssharedflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PitStopViewModel : ViewModel() {

    private val _lapCount = MutableStateFlow<Int>(0)
    val lapCount: StateFlow<Int> = _lapCount.asStateFlow()

    private val _pitStopAlert = MutableSharedFlow<String>()
    val pitStopAlert: SharedFlow<String> = _pitStopAlert.asSharedFlow()

    fun nextLap() {
        _lapCount.value++
    }

    fun triggerPitStop(reason: String) {
        viewModelScope.launch {
            _pitStopAlert.emit("Pit Stop! Reason: $reason")
        }
    }

    fun reset() {
        _lapCount.value = 0
    }
}