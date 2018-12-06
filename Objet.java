package com.example.to.myapplication;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Objet {

    private String nom;
    private Rarete rarete;
    private ImageView imageView;
    private int idFusion;
    private List<String> objetsCommuns;
    private List<String> objetsInhabituels;
    private List<String> objetsRares;
    private List<String> objetsMythiques;
    private List<String> objetsMagiques;

    public Objet(String nom, Rarete rarete, ImageView imageView) {
        this.nom = nom;
        this.idFusion = getIdFusion();
        this.rarete = rarete;
        this.imageView = imageView;
    }

    public Objet fusion(Objet o1, Objet o2) {

        this.objetsCommuns = new ArrayList<String>();
        this.objetsInhabituels = new ArrayList<String>();
        this.objetsRares = new ArrayList<String>();
        this.objetsMythiques = new ArrayList<String>();
        this.objetsMagiques = new ArrayList<String>();

        objetsCommuns.add("Plume");
        objetsCommuns.add("Papier");
        objetsCommuns.add("Lumière");
        objetsCommuns.add("Tête");
        objetsCommuns.add("Horloge");
        objetsCommuns.add("Bracelet");
        objetsCommuns.add("Bol");
        objetsCommuns.add("Cuillère");
        objetsCommuns.add("Ficelle");
        objetsCommuns.add("Branche");
        objetsCommuns.add("Boule de feu");
        objetsCommuns.add("Bouteille d'alcool");
        objetsCommuns.add("Camembert");
        objetsCommuns.add("Baguette");
        objetsCommuns.add("Tissu");
        objetsCommuns.add("Caoutchouc");

        objetsInhabituels.add("Livre");
        objetsInhabituels.add("Cerveau");
        objetsInhabituels.add("Montre");
        objetsInhabituels.add("Casserole");
        objetsInhabituels.add("Canne à pêche");
        objetsInhabituels.add("Cocktail molotov");
        objetsInhabituels.add("Drapeau français");
        objetsInhabituels.add("Ballon de foot");

        objetsRares.add("Dictionnaire");
        objetsRares.add("Cocotte minute");
        objetsRares.add("Missile");
        objetsRares.add("Étoile");

        objetsMythiques.add("Livre des recettes");
        objetsMythiques.add("Étoile filante");

        objetsMagiques.add("Livre d'or des fusions");

        if ((o1.getRarete() == o2.getRarete() && o1.getIdFusion() == o2.getIdFusion())) {

            if (o1.getRarete() == Rarete.COMMUN) {
                for (String s : objetsCommuns) {
                    if (s.equals(o1.getNom())) {
                        int positionObjet = objetsCommuns.indexOf(s);
                        positionObjet = positionObjet / 2;
                        o1.setNom(objetsInhabituels.get(positionObjet));
                        o1.setRarete(Rarete.INHABITUEL);
                        getIdFusion();
                    }
                }
            }

            else if (o1.getRarete() == Rarete.INHABITUEL) {
                for (String s : objetsInhabituels) {
                    if (s.equals(o1.getNom())) {
                        int positionObjet = objetsInhabituels.indexOf(s);
                        positionObjet = positionObjet / 2;
                        o1.setNom(objetsRares.get(positionObjet));
                        o1.setRarete(Rarete.RARE);
                        getIdFusion();
                    }
                }
            }

            else if (o1.getRarete() == Rarete.RARE) {
                for (String s : objetsRares) {
                    if (s.equals(o1.getNom())) {
                        int positionObjet = objetsRares.indexOf(s);
                        positionObjet = positionObjet / 2;
                        o1.setNom(objetsMythiques.get(positionObjet));
                        o1.setRarete(Rarete.MYTHIQUE);
                        getIdFusion();
                    }
                }
            }

            else if (o1.getRarete() == Rarete.MYTHIQUE) {
                for (String s : objetsCommuns) {
                    if (s.equals(o1.getNom())) {
                        o1.setNom("livre d'or des fusions");
                        o1.setRarete(Rarete.MAGIQUE);
                        getIdFusion();
                    }
                }
            }
        } else {
            System.out
                    .println("Aucune fusion n'est possible avec l'objet " + o1.getNom() + " et l'objet " + o2.getNom());
        }
        System.out.println(o1.getNom() + " : " + o1.getRarete());
        return o1;

    }

    public int getIdFusion() {
        switch (this.nom) {

            case "ficelle":
            case "branche":
                this.idFusion = 1;
                break;

            case "boule de feu":
            case "bouteille d'alcool":
                this.idFusion = 2;
                break;

            case "plume":
            case "papier":
                this.idFusion = 3;
                break;

            case "horloge":
            case "bracelet":
                this.idFusion = 4;
                break;

            case "bol":
            case "cuillère":
                this.idFusion = 5;
                break;

            case "tissu":
            case "caoutchouc":
                this.idFusion = 6;
                break;

            case "lumière":
            case "tête":
                this.idFusion = 7;
                break;

            case "canne à pêche":
            case "cocktail molotov":
                this.idFusion = 8;
                break;

            case "livre":
            case "cerveau":
                this.idFusion = 9;
                break;

            case "casserole":
            case "montre":
                this.idFusion = 10;
                break;

            case "ballon de foot":
            case "drapeau français":
                this.idFusion = 11;
                break;

            case "cocotte minute":
            case "dictionnaire":
                this.idFusion = 12;
                break;

            case "étoile":
            case "missile":
                this.idFusion = 13;
                break;

            case "étoile filante":
            case "livre des recettes":
                this.idFusion = 14;
                break;

            case "livre d'or des fusions":
                this.idFusion = 15;
                break;
        }

        return idFusion;
    }

    public void setIdFusion(int idFusion) {
        this.idFusion = idFusion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }
}

