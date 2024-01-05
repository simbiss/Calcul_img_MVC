package com.example.calcul_img_mvc.modele;

import java.util.Date;

public class Profil {

    //constantes
    private static final int minFemme = 15;
    private static final int maxFemme = 30;
    private static final int minHomme = 10;
    private static final int maxHomme = 25;

    //proprietés
    private int poids;
    private int taille;
    private int age;
    private int sexe;
    private double img;
    private String message;
    private Date dateMesure;

    public Profil(Date dateMesure, int poids, int taille, int age, int sexe) {
        this.poids = poids;
        this.taille =taille;
        this.age = age;
        this.sexe = sexe;
        this.dateMesure = dateMesure;
        calculIMG();
        resulatIMG();
    }

    //méthode calcule img --> IMG (%) = (1,2 x IMC) + (0,23 x âge) - (10,8 x sexe )
    private void calculIMG(){
        double tailleM = (double) taille/100;
        img = (double)(1.2 * poids / (tailleM * tailleM) + (0.23 * age) - (10.83 * sexe) - 5.4);
    }

    //méthode retourn le message approprier selon l'img de l'utilisateur
    private void resulatIMG(){
        int min;
        int max;
        if (sexe == 0){
            min = minFemme;
            max = maxFemme;
        } else {
            min = minHomme;
            max = maxHomme;
        }
        // message de retour
        message = "Normal";
        if (img < min){
            message = "Trop faible";
        } else {
            if (img > max) {
                message = "Trop élevé";
            }
        }
    }

    //getter
    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getSexe() {
        return sexe;
    }

    public double getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateMesure() {
        return dateMesure;
    }
}
