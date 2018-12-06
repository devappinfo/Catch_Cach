package com.example.to.myapplication;


import android.content.Context;
import android.location.LocationManager;

import com.example.to.myapplication.MainActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Cache {



    private String nom;
    private String qRCode;
    private LatLng coordonnees;
    public MainActivity context;
    private boolean me;

    public String getDescription() {
        return description;
    }

    private String description;


    public  Cache( String pNom, String pDescription, String QRCode, LatLng pCoordonnees){
        nom = pNom;
        description = pDescription;
        coordonnees = pCoordonnees;
        qRCode = QRCode;
        me= true;


    }
    public String getNom() {
        return nom;
    }




}
