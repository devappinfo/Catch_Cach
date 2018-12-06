package com.example.tom_j.objets_geocaching;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;

import static com.example.tom_j.objets_geocaching.R.id.imageViewResource;

public class MainActivity extends AppCompatActivity {

    Utilisateur unUser;
    Objet unObjet;
    Objet unObjet2;
    Objet unObjet3;
    Objet unObjet4;
    Objet unObjet5;
    Objet unObjet6;
    ImageView uneImage;
    LinearLayout linearLayoutCommuns;
    LinearLayout linearLayoutInhabituels;
    LinearLayout linearLayoutRares;
    LinearLayout linearLayoutMythiques;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unUser = new Utilisateur();
        linearLayoutCommuns = (LinearLayout) findViewById(R.id.linearLayoutCommuns);
        linearLayoutInhabituels = (LinearLayout) findViewById(R.id.linearLayoutInhabituels);
        linearLayoutRares = (LinearLayout) findViewById(R.id.linearLayoutRares);
        linearLayoutMythiques = (LinearLayout) findViewById(R.id.linearLayoutMythiques);
        findViewById(R.id.imageViewResource).setOnDragListener(new MyDragListener());
        findViewById(R.id.imageViewResource2).setOnDragListener(new MyDragListener());

        uneImage = (ImageView) findViewById(R.id.imageView3);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.etoilefilantepetite);
        img.setOnTouchListener(new MyTouchListener());


        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.livrerecettepetite);
        img2.setOnTouchListener(new MyTouchListener());
        ImageView img3 = new ImageView(this);
        img3.setImageResource(R.drawable.branchepetite);
        img3.setOnTouchListener(new MyTouchListener());



        ImageView img4 = new ImageView(this);
        img4.setImageResource(R.drawable.bolpetite);
        img4.setOnTouchListener(new MyTouchListener());


        ImageView img5 = new ImageView(this);
        img5.setImageResource(R.drawable.ficellepetite);
        img5.setOnTouchListener(new MyTouchListener());


        ImageView img6 = new ImageView(this);
        img6.setImageResource(R.drawable.braceletpetite);
        img6.setOnTouchListener(new MyTouchListener());


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

    final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                // view.setVisibility(View.VISIBLE);

                return true;
            } else {
                //view.setVisibility(View.INVISIBLE);
                return false;
            }
        }
    }



    public class MyDragListener extends AppCompatActivity implements View.OnDragListener {
        MainActivity a = new MainActivity();
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            View view = (View) event.getLocalState();
            ImageView drop = (ImageView) view;
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    drop.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    drop.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    drop.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DROP:
                    a.changerImage(drop);
                    drop.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                default:
                    break;
            }
            return true;
        }
    }

    private void changerImage(ImageView drop) {

    }

    public void pageFusion(View v) {
        startActivity(new Intent(this, Fusion.class));
    }
}
