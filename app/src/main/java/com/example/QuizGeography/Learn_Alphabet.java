package com.example.QuizGeography;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Learn_Alphabet extends AppCompatActivity {

    CardView cardView01;
    CardView cardView02;
    CardView cardView03;
    CardView cardView04;
    CardView cardView05;
    CardView cardView06;
    CardView cardView07;
    CardView cardView08;
    CardView cardView09;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn__alphabet);

        cardView01 = findViewById(R.id.cardView01);
        cardView02 = findViewById(R.id.cardView02);
        cardView03 = findViewById(R.id.cardView03);
        cardView04 = findViewById(R.id.cardView04);
        cardView05 = findViewById(R.id.cardView05);
        cardView06 = findViewById(R.id.cardView06);
        cardView07 = findViewById(R.id.cardView07);
        cardView08 = findViewById(R.id.cardView08);
        cardView09 = findViewById(R.id.cardView09);

        cardView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Abd_Cin.class);
                startActivity(intent);
            }
        });

        cardView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Dan_Fin.class);
                startActivity(intent);
            }
        });

        cardView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Fra_Ing.class);
                startActivity(intent);
            }
        });

        cardView04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Iran_Kol.class);
                startActivity(intent);
            }
        });

        cardView05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Kos_Misir.class);
                startActivity(intent);
            }
        });

        cardView06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Mog_Per.class);
                startActivity(intent);
            }
        });

        cardView07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Pol_Sir.class);
                startActivity(intent);
            }
        });

        cardView08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Slo_Tun.class);
                startActivity(intent);
            }
        });

        cardView09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Learn_Alphabet.this, Learn_Tur_Zim.class);
                startActivity(intent);
            }
        });



    }


}
