package com.siri.data

import androidx.annotation.DrawableRes

data class TaxiBookingUiState(
    val origin: Location? = null,
    val destination: Location? = null,
    val route: List<Location> = emptyList(),
    val selectedTransport: TransportType? = null,
)

enum class TransportType(
    val displayName: String,
    @DrawableRes val iconRes: Int
) {
    MOTORBIKE("Motorbike", R.drawable.ic_motorbike),
    TAXI_NORMAL("Taxi Normal", R.drawable.ic_taxi),
    TAXI_BIG("Taxi Big", R.drawable.ic_taxi),
    VAN("Van", R.drawable.ic_van)
}

val transportPrices = mapOf(
    TransportType.MOTORBIKE to "3-5 Euro per Km",
    TransportType.TAXI_NORMAL to "1.5-2.5 Euro per Km",
    TransportType.TAXI_BIG to "2.5-3.5 Euro per Km",
    TransportType.VAN to "3-4 Euro per Km"
)
