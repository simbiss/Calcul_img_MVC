package com.example.calcul_img_mvc.modele;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.example.calcul_img_mvc.outils.MySQLiteHelper;

public class AccesLocal {
    private String nomBase = "bdProfil.bd";
    private int versionBase = 1;
    private MySQLiteHelper accesBD;
    private SQLiteDatabase db;

    public AccesLocal(Context context) {
        accesBD = new MySQLiteHelper(context, nomBase, null, versionBase);
    }

    public void ajout (Profil profil){
        db = accesBD.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put("DateMesure", String.valueOf(profil.getDateMesure()));
        valeurs.put("poids", profil.getPoids());
        valeurs.put("taille", profil.getTaille());
        valeurs.put("age",profil.getAge());
        valeurs.put("sexe", profil.getSexe());

        db.insert("Profis", null, valeurs);
        db.close();
    }


}
