package com.example.to.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;

public class InventaireActivity extends AppCompatActivity {

    Utilisateur unUser;
    Objet unObjet;
    Objet unObjet2;
    Objet unObjet3;
    Objet unObjet4;
    Objet unObjet5;
    Objet unObjet6;
    Button button;
    LinearLayout linearLayoutCommuns;
    LinearLayout linearLayoutInhabituels;
    LinearLayout linearLayoutRares;
    LinearLayout linearLayoutMythiques;
    ImageButton info;
    ImageView infoImg;

    @SuppressLint({"WrongViewCast", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);
        unUser = new Utilisateur();
        linearLayoutCommuns = (LinearLayout) findViewById(R.id.linearLayoutCommuns);
        linearLayoutInhabituels = (LinearLayout) findViewById(R.id.linearLayoutInhabituels);
        linearLayoutRares = (LinearLayout) findViewById(R.id.linearLayoutRares);
        linearLayoutMythiques = (LinearLayout) findViewById(R.id.linearLayoutMythiques);

        //uneImage = (ImageView) findViewById(R.id.imageView3);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.etoilefilante);



        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.livrerecette);
        ImageView img3 = new ImageView(this);
        img3.setImageResource(R.drawable.branche);


        ImageView img4 = new ImageView(this);
        img4.setImageResource(R.drawable.bol);


        ImageView img5 = new ImageView(this);
        img5.setImageResource(R.drawable.ficelle);


        ImageView img6 = new ImageView(this);
        img6.setImageResource(R.drawable.bracelet);

        button = findViewById(R.id.button);
        //  linearLayoutInhabituels.addView(img2);
        // Log.e("a","image2");
        //   linearLayoutInhabituels.addView(img);
        // Log.e("a","image1");

        unObjet3 = new Objet("Branche", Rarete.COMMUN, img3);
        unUser.getListeObjet().add(unObjet3);

        unObjet4 = new Objet("Bol", Rarete.COMMUN, img4);
        unUser.getListeObjet().add(unObjet4);

        unObjet5 = new Objet("Ficelle", Rarete.COMMUN, img5);
        unUser.getListeObjet().add(unObjet5);
        unObjet6 = new Objet("Bracelet", Rarete.COMMUN, img6);
        unUser.getListeObjet().add(unObjet6);

        unObjet = new Objet("Étoile filante", Rarete.MYTHIQUE, img);
        unUser.getListeObjet().add(unObjet);

        unObjet2 = new Objet("Livre des recettes", Rarete.MYTHIQUE, img2);
        unUser.getListeObjet().add(unObjet2);
        afficherObjet();
        infoImg = findViewById(R.id.infoImg);
        infoImg.setImageResource(0);
        info = findViewById(R.id.info);
        info.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent me) {
                switch(me.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        infoImg.setImageResource(R.drawable.fusions);
                        button.setVisibility(View.INVISIBLE);

                        break;
                    case MotionEvent.ACTION_MOVE:
                        infoImg.setImageResource(R.drawable.fusions);
                        button.setVisibility(View.INVISIBLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        infoImg.setImageResource(0);
                        button.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        });


    }

    public void afficherObjet() {
        for (Objet o : unUser.getListeObjet()) {
            Log.i("test", o.getNom());

            switch (o.getRarete()) {
                case COMMUN:
                    linearLayoutCommuns.addView(o.getImageView());
                    break;
                case INHABITUEL:
                    linearLayoutInhabituels.addView(o.getImageView());
                    break;
                case RARE:
                    linearLayoutRares.addView(o.getImageView());
                    break;
                case MYTHIQUE:
                    linearLayoutMythiques.addView(o.getImageView());
                    break;
            }
        }
    }

    public void pageFusion(View v) {
        startActivity(new Intent(this, Fusion.class));
    }
}
