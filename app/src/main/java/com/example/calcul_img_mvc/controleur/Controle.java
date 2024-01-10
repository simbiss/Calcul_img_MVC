package com.example.calcul_img_mvc.controleur;

import android.content.Context;

import com.example.calcul_img_mvc.modele.Profil;
import com.example.calcul_img_mvc.modele.AccesLocal;

import java.util.Date;

public final class Controle {
    private static Controle instance = null;

    private static Profil profil;
    private static AccesLocal accesLocal;


    /**
     * constructeur privé
     */
    private Controle(){
        super();
    }

    /**
     *Creation de l'instance
     * @return instance
     */
    public static Controle getInstance(Context context){
        if (instance == null) {
            instance = new Controle();
            accesLocal = new AccesLocal(context);
        }
        return instance;
    }

    /**
     *Creation du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme 0 pour femme
     */
    public void creerProfil (int poids, int taille, int age, int sexe){
        profil = new Profil(new Date(), poids, taille, age, sexe);
        accesLocal.ajout(profil);
    }


    /**
     *recuperation de IMG
     * @return img calculé
     */
    public double getIMG(){return profil.getImg();}


    /**
     *
     * @return
     */
    public String getMessage(){return profil.getMessage();}

}
