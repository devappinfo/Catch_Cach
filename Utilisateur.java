package com.example.tom_j.objets_geocaching;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

    private List<Objet> listeObjet;
    Objet unObjet;
    public Utilisateur() {
      listeObjet = new ArrayList<>();
    }

    public List<Objet> getListeObjet() {
        return listeObjet;
    }
}
