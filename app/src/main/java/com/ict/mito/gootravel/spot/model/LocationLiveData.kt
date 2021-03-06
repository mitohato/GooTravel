package com.ict.mito.gootravel.spot.model

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import androidx.lifecycle.LiveData
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.ict.mito.gootravel.util.LocationRequestAlertDialog

/**
 * Created by mitohato14 on 2019-08-01.
 */
class LocationLiveData(
    val context: Context
) : LiveData<Location>() {
    private lateinit var googleApiClient: GoogleApiClient
    private lateinit var locationRequest: LocationRequest

    private val googleConnectionFailedListener = GoogleApiClient.OnConnectionFailedListener {
    }

    private val googleApiClientConnectionCallbacks = object : GoogleApiClient.ConnectionCallbacks {
        override fun onConnected(p0: Bundle?) {
        }

        override fun onConnectionSuspended(p0: Int) {
            googleApiClient.connect()
        }
    }

    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        googleApiClient = GoogleApiClient.Builder(context)
            .addConnectionCallbacks(googleApiClientConnectionCallbacks)
            .addOnConnectionFailedListener(googleConnectionFailedListener)
            .addApi(LocationServices.API)
            .build()

        createLocationRequest()
        val locationClient = LocationServices.getFusedLocationProviderClient(context)
        locationClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult?) {
                    super.onLocationResult(p0)
                    p0?.let { updateLocationInfo(it.lastLocation) }
                }
            },
            Looper.myLooper()
        )

        val locationManager = context.getSystemService(Activity.LOCATION_SERVICE) as LocationManager?
        if (locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) != true) {
            LocationRequestAlertDialog().showsDialog
        }
        locationClient.lastLocation.addOnSuccessListener {
            it?.let { updateLocationInfo(it) }
        }

        googleApiClient.connect()
    }

    override fun onInactive() {
        super.onInactive()
        googleApiClient.disconnect()
    }

    private fun updateLocationInfo(location: Location) {
        value = location
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.also {
            it.interval = 1000
            it.fastestInterval = 500
            it.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }
}
