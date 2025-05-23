package com.siri.taxi.ui.screens.maps

// Jetpack Compose
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.GoogleMap

// Google Maps Compose
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

// Maps Models
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MarkerState

@Composable
fun RideEasyMap(origin: LatLng?, destination: LatLng?, route: List<LatLng>) {
    val cameraPosition = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(origin ?: LatLng(13.7563, 100.5018), 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPosition
    ) {
        origin?.let {
            Marker(
                state = MarkerState(position = it),
                title = "Current Position"
            )
        }

        destination?.let {
            Marker(
                state = MarkerState(position = it),
                title = "Destination"
            )
        }

        if (route.isNotEmpty()) {
            Polyline(
                points = route,
                color = Color.Blue
            )
        }
    }
}
