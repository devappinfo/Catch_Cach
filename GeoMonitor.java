package com.example.i171303.geofencing;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

public class GeoMonitor {

    //Ne pas oublier de mettre dans build.gradle implementation 'com.google.android.gms:play-services-maps:16.0.0'

    GoogleApiClient googleApiClient = null;
    LatLng latLng;

    public GeoMonitor(Context pContext){

        googleApiClient = new GoogleApiClient.Builder(pContext)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {

                    @Override
                    public void onConnected(Bundle bundle) {
                        Log.d("", "Connected to GoogleApiClient");
                    }

                    @Override
                    public void onConnectionSuspended(int i) {
                        Log.d("", "Suspended connection to GoogleApiClient");
                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.d("", "Failed to connect to GoogleApiClient - " + connectionResult.getErrorMessage());
                    }
                })
                .build();
    }

    private LatLng getLocation() {
        Log.d("", "Enter location getter");

        try {
            LocationRequest locationRequest = LocationRequest.create()
                    .setInterval(1000)
                    .setFastestInterval(500)
                    //.setNumUpdates(5)
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,
                    locationRequest, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            Log.d("", "Location update lat/long " + location.getLatitude() + " " + location.getLongitude());
                            if (location.getLatitude() != 0 && location.getLongitude() != 0){
                                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            }
                        }
                    });

            return latLng;
        } catch (SecurityException e){
            Log.d("", "SecurityException - " + e.getMessage());
        }
        return null;
    }
}
