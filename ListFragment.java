package com.example.to.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.to.myapplication.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ListFragment extends Fragment {
ScrollView scroll;
View mView;
    public static List<Cache> listeCaches = new ArrayList<>() ;
    public List<Button> mesBoutons;
    LinearLayout liste;
MainActivity context;
TextView nom;
TextView description;
Switch aSwitch;
Button inventaire;




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.fragment_list, container, false);

return mView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        nom = getActivity().findViewById(R.id.nom);
        description = getActivity().findViewById(R.id.description);
        aSwitch = getActivity().findViewById(R.id.switch1);
        inventaire = getActivity().findViewById(R.id.inventaire);
        inventaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),InventaireActivity.class);
                getActivity().startActivity(i);
            }
        });


        ListFragment.listeCaches.add(new Cache("1", "des1","444", new LatLng(12,13)));
        ListFragment.listeCaches.add(new Cache("2", "des2","444", new LatLng(12,13)));
        for ( final Cache c : listeCaches){
           final List <Integer> idButtons = new ArrayList<>();
            final List <Cache> mesCaches = new ArrayList<>();



         final Button myButton = new Button(getActivity());
         myButton.setText(c.getNom().toString());
         liste = (LinearLayout) getActivity().findViewById(R.id.liste);
         liste.addView(myButton);
         idButtons.add(myButton.getId());

         mesCaches.add(c);


         myButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.e("1", String.valueOf(v.getId()));
                 int indice =idButtons.indexOf(v.getId());

                 nom.setText(mesCaches.get(indice).getNom());
                 description.setText(mesCaches.get(indice).getDescription());


             }
         });

        }


    }



}
