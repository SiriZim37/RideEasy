package com.siri.data.extensions

import com.siri.data.Location
import com.google.android.gms.maps.model.LatLng

fun Location.toLatLng(): LatLng = LatLng(this.latitude, this.longitude)
