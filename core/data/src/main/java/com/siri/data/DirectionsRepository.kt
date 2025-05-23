package com.siri.data

import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class DirectionsRepository @Inject constructor() {

    suspend fun getRoute(origin: LatLng, destination: LatLng): List<LatLng> {
        // TODO: call Google Directions API hier
        return emptyList()
    }
}
