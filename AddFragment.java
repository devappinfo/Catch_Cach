package com.example.to.myapplication;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;



public class AddFragment extends Fragment implements View.OnClickListener, LocationListener{
    private Button fab;
    View mView;
    MainActivity main;


    public TextInputEditText nom;
    public TextInputEditText description;
    public LocationManager locationManager;

    double longitude; // ici
    double latitude; // ici

    ListFragment list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_add, container, false);

        nom= (TextInputEditText)mView.findViewById(R.id.nom) ;
        description= (TextInputEditText)mView.findViewById(R.id.description) ;
        locationManager =(LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE); // ici

        fab = (Button) mView.findViewById(R.id.fab);

        fab.setOnClickListener(this);


        return  mView;


    }


    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        scannerQRCode();
    }


    public void scannerQRCode(){
        try{
            Intent intent =  new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        }
        catch (Exception e){
            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent= new Intent(Intent.ACTION_VIEW, marketUri);
            startActivity(marketIntent);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0){
            if(resultCode == RESULT_OK){
                String infoDansQRCode = data.getStringExtra("SCAN_RESULT");
                Log.e("scanner", infoDansQRCode);
                Cache uneCache =  new Cache( nom.getText().toString(),description.getText().toString(),infoDansQRCode,  new LatLng(latitude, longitude));
                ListFragment.listeCaches.add(uneCache);


                Log.i("test1111","wesh alorsssssssssssssssssssssssssssssssss");
            }


        }


}

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
