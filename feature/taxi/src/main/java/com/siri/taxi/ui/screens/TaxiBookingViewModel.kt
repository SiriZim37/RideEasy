package com.siri.taxi.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.siri.data.DirectionsRepository
import com.siri.data.Location
import com.siri.data.TaxiBookingUiState
import com.siri.data.TransportType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaxiBookingViewModel @Inject constructor(
    private val directionsRepository: DirectionsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TaxiBookingUiState())
    val uiState: StateFlow<TaxiBookingUiState> = _uiState

    fun onTransportSelected(type: TransportType) {
        _uiState.update { it.copy(selectedTransport = type) }
    }

    fun openChat() {
        // Navigate to chat screen
    }

    fun confirmSelection() {
        val origin = _uiState.value.origin
        val destination = _uiState.value.destination

        if (origin != null && destination != null) {
            viewModelScope.launch {
                val route = directionsRepository.getRoute(
                    LatLng(origin.latitude, origin.longitude),
                    LatLng(destination.latitude, destination.longitude)
                )
                _uiState.update { it.copy(route = route.map { Location(it.latitude, it.longitude) }) }
            }
        }
    }
}
