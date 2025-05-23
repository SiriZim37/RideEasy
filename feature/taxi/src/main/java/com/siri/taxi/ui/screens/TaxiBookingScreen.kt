package com.siri.taxi.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.siri.navigation.navigator.NavigatorImpl
import com.siri.taxi.ui.screens.components.TransportSelectionBottomSheet

import com.siri.navigation.NavScreens
import com.siri.taxi.ui.screens.maps.FakeMapPlaceholder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaxiBookingScreen(
    navigator: NavigatorImpl,
    viewModel: TaxiBookingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        // Add a TopAppBar with back button
        TopAppBar(
            title = { Text("Taxi Booking") },
            navigationIcon = {
                IconButton(onClick = {
                    navigator.navigateTo(NavScreens.Home.route)
                }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )

        // Map
//        RideEasyMap(
//            origin = uiState.origin?.toLatLng(),
//            destination = uiState.destination?.toLatLng(),
//            route = uiState.route.map { it.toLatLng() } // แปลงทุก Location ใน list เป็น LatLng
//        )
        FakeMapPlaceholder()

        // Bottom Sheet
        TransportSelectionBottomSheet(
            selectedType = uiState.selectedTransport,
            onTypeSelected = viewModel::onTransportSelected,
            onConfirm = viewModel::confirmSelection
        )



        // Floating Chat Button
        FloatingActionButton(
            onClick = { viewModel.openChat() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.MailOutline, contentDescription = "Chat")
        }
    }
}
