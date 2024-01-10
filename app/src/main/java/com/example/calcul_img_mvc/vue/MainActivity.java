package com.example.calcul_img_mvc.vue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.calcul_img_mvc.R;
import com.example.calcul_img_mvc.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    EditText txtPoids, txtTaille, txtAge;
    TextView lbResult;
    ImageView imgIcon;
    RadioButton rbHomme;
    Controle controle;
    double img;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init() {
        txtPoids = findViewById(R.id.txtPoids);
        txtTaille = findViewById(R.id.txtTaille);
        txtAge = findViewById(R.id.txtAge);
        lbResult = findViewById(R.id.lbResult);
        imgIcon = findViewById(R.id.imgSmiley);
        rbHomme = findViewById(R.id.rbHomme);
        rbHomme.setChecked(true);
    }

    public void calcul_click(View v) {
        int poids = 0;
        int taille = 0;
        int age = 0;
        int sexe = 0;

        try {
            poids = Integer.parseInt(txtPoids.getText().toString());
            taille = Integer.parseInt(txtTaille.getText().toString());
            age = Integer.parseInt(txtAge.getText().toString());
        } catch (Exception e) {

        }

        if (rbHomme.isChecked()) {
            sexe = 1;
        }
        if (poids == 0 || taille == 0 || age == 0) {
            Toast.makeText(MainActivity.this, "Saisie Incorrecte", Toast.LENGTH_LONG).show();
        } else {
            calculerResult(poids, taille, age, sexe);
            afficherResult();
        }
    }

    private void calculerResult(int poids, int taille, int age, int sexe) {
        this.controle.creerProfil(poids, taille, age, sexe);
        img = this.controle.getIMG();
        message = this.controle.getMessage();
    }


    private void afficherResult() {
        if (message == "Normal") {
            imgIcon.setImageResource(R.drawable.normal);
            lbResult.setTextColor(Color.GREEN);
        } else {
            if (message == "Trop faible") {
                imgIcon.setImageResource(R.drawable.maigre);
                lbResult.setTextColor(Color.RED);
            } else {
                imgIcon.setImageResource(R.drawable.gros);
                lbResult.setTextColor(Color.RED);
            }
        }
        lbResult.setText(String.format("%.01f", img) + " : IMG " + message);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("IMG", img);
        outState.putString("MESSAGE", message);
    }


}
