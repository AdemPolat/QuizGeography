package com.example.QuizGeography;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {

    int StoredScore;
    int StoredScore2;
    int StoredScore3;

    int StoredScore4;
    int StoredScore5;
    int StoredScore6;

    int StoredScore7;
    int StoredScore8;
    int StoredScore9;


    TextView textFlagHigh1;
    TextView textFlagHigh2;
    TextView textFlagHigh3;

    TextView textCapitalHigh1;
    TextView textCapitalHigh2;
    TextView textCapitalHigh3;

    TextView textCountryHigh1;
    TextView textCountryHigh2;
    TextView textCountryHigh3;

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high_score);

        textFlagHigh1= findViewById(R.id.textFlagHigh1);
        textFlagHigh2= findViewById(R.id.textFlagHigh2);
        textFlagHigh3= findViewById(R.id.textFlagHigh3);

        textCapitalHigh1= findViewById(R.id.textCapitalHigh1);
        textCapitalHigh2= findViewById(R.id.textCapitalHigh2);
        textCapitalHigh3= findViewById(R.id.textCapitalHigh3);

        textCountryHigh1= findViewById(R.id.textCountryHigh1);
        textCountryHigh2= findViewById(R.id.textCountryHigh2);
        textCountryHigh3= findViewById(R.id.textCountryHigh3);

        Intent intent= getIntent();
        String uFlagHigh1 = intent.getStringExtra("userFlagHigh1");
        String uFlagHigh2 = intent.getStringExtra("userFlagHigh2");
        String uFlagHigh3 = intent.getStringExtra("userFlagHigh3");

        String uCapitalHigh1 = intent.getStringExtra("userCapitalHigh1");
        String uCapitalHigh2 = intent.getStringExtra("userCapitalHigh2");
        String uCapitalHigh3 = intent.getStringExtra("userCapitalHigh3");

        String uCountryHigh1 = intent.getStringExtra("userCountryHigh1");
        String uCountryHigh2 = intent.getStringExtra("userCountryHigh2");
        String uCountryHigh3 = intent.getStringExtra("userCountryHigh3");

        textFlagHigh1.setText(""+uFlagHigh1);
        textFlagHigh2.setText(""+uFlagHigh2);
        textFlagHigh3.setText(""+uFlagHigh3);

        textCapitalHigh1.setText(""+uCapitalHigh1);
        textCapitalHigh2.setText(""+uCapitalHigh2);
        textCapitalHigh3.setText(""+uCapitalHigh3);

        textCountryHigh1.setText(""+uCountryHigh1);
        textCountryHigh2.setText(""+uCountryHigh2);
        textCountryHigh3.setText(""+uCountryHigh3);

       sharedPreferences =this.getSharedPreferences("com.example.QuizGeography", Context.MODE_PRIVATE);  // Shared Preferences

         StoredScore = sharedPreferences.getInt("StoredScore", 0);
         StoredScore2 = sharedPreferences.getInt("StoredScore2", 0);
         StoredScore3 = sharedPreferences.getInt("StoredScore3", 0);

         StoredScore4 = sharedPreferences.getInt("StoredScore4", 0);
         StoredScore5 = sharedPreferences.getInt("StoredScore5", 0);
         StoredScore6 = sharedPreferences.getInt("StoredScore6", 0);

         StoredScore7 = sharedPreferences.getInt("StoredScore7", 0);
         StoredScore8 = sharedPreferences.getInt("StoredScore8", 0);
         StoredScore9 = sharedPreferences.getInt("StoredScore9", 0);

        textFlagHigh1.setText(""+StoredScore);
        textFlagHigh2.setText(""+StoredScore2);
        textFlagHigh3.setText(""+StoredScore3);

        textCountryHigh1.setText(""+StoredScore7);
        textCountryHigh2.setText(""+StoredScore8);
        textCountryHigh3.setText(""+StoredScore9);

        textCapitalHigh1.setText(""+StoredScore4);
        textCapitalHigh2.setText(""+StoredScore5);
        textCapitalHigh3.setText(""+StoredScore6);

    }

    public void deleteFlag(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(HighScore.this);  // Uyarı mesajını açar
        alert.setTitle("UYARI");
        alert.setMessage("Skorları silmek istiyor musunuz?");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                textFlagHigh1.setText("0");
                textFlagHigh2.setText("0");
                textFlagHigh3.setText("0");

                int hScore = Integer.parseInt(textFlagHigh1.getText().toString());
                int hScore2 = Integer.parseInt(textFlagHigh2.getText().toString());
                int hScore3 = Integer.parseInt(textFlagHigh2.getText().toString());

                sharedPreferences.edit().putInt("StoredScore",hScore).apply();
                sharedPreferences.edit().putInt("StoredScore2",hScore2).apply();
                sharedPreferences.edit().putInt("StoredScore3",hScore3).apply();


            }
        });

        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        alert.show();



    }

    public void deleteCountry(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(HighScore.this);  // Uyarı mesajını açar
        alert.setTitle("UYARI");
        alert.setMessage("Skorları silmek istiyor musunuz?");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                textCountryHigh1.setText("0");
                textCountryHigh2.setText("0");
                textCountryHigh3.setText("0");

                int hScore = Integer.parseInt(textCountryHigh1.getText().toString());
                int hScore2 = Integer.parseInt(textCountryHigh2.getText().toString());
                int hScore3 = Integer.parseInt(textCountryHigh3.getText().toString());

                sharedPreferences.edit().putInt("StoredScore7",hScore).apply();
                sharedPreferences.edit().putInt("StoredScore8",hScore2).apply();
                sharedPreferences.edit().putInt("StoredScore9",hScore3).apply();


            }
        });

        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        alert.show();

    }

    public void deleteCapital(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(HighScore.this);  // Uyarı mesajını açar
        alert.setTitle("UYARI");
        alert.setMessage("Skorları silmek istiyor musunuz?");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                textCapitalHigh1.setText("0");
                textCapitalHigh2.setText("0");
                textCapitalHigh3.setText("0");

                int hScore = Integer.parseInt(textCapitalHigh1.getText().toString());
                int hScore2 = Integer.parseInt(textCapitalHigh2.getText().toString());
                int hScore3 = Integer.parseInt(textCapitalHigh3.getText().toString());

                sharedPreferences.edit().putInt("StoredScore4",hScore).apply();
                sharedPreferences.edit().putInt("StoredScore5",hScore2).apply();
                sharedPreferences.edit().putInt("StoredScore6",hScore3).apply();


            }
        });

        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        alert.show();



    }


}
