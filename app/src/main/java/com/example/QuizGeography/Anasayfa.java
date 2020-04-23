package com.example.QuizGeography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Anasayfa extends AppCompatActivity {

    CountDownTimer myCountDownTimer;
    Button buttonFlag;
    Button buttonCountry;
    Button buttonCapital;
    Button buttonLearn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);

         buttonFlag = findViewById(R.id.buttonFlag);
         buttonCountry= findViewById(R.id.buttonCountry);
         buttonCapital= findViewById(R.id.buttonCapital);
         buttonLearn= findViewById(R.id.buttonLearn);

         buttonCapital.setVisibility(View.INVISIBLE);
        buttonCountry.setVisibility(View.INVISIBLE);
        buttonFlag.setVisibility(View.INVISIBLE);
        buttonLearn.setVisibility(View.INVISIBLE);


        myCountDownTimer = new CountDownTimer(1000,200) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

                if(millisUntilFinished > 800){

                    Animation blink = AnimationUtils.loadAnimation(Anasayfa.this,R.anim.blink);
                    buttonFlag.startAnimation(blink);
                    buttonFlag.setVisibility(View.VISIBLE);
                }
                else if(millisUntilFinished > 600){

                    Animation blink = AnimationUtils.loadAnimation(Anasayfa.this,R.anim.blink);
                    buttonCountry.startAnimation(blink);
                    buttonCountry.setVisibility(View.VISIBLE);
                }
                else if(millisUntilFinished > 400){

                    Animation blink = AnimationUtils.loadAnimation(Anasayfa.this,R.anim.blink);
                    buttonCapital.startAnimation(blink);
                    buttonCapital.setVisibility(View.VISIBLE);
                }

                else if(millisUntilFinished > 200){

                    Animation blink = AnimationUtils.loadAnimation(Anasayfa.this,R.anim.blink);
                    buttonLearn.startAnimation(blink);

                    buttonLearn.setVisibility(View.VISIBLE);
                }


            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

            }
        }.start();
    }

    public  void learn(View view){
        Intent intent = new Intent(Anasayfa.this, Learn_Alphabet.class);
        startActivity(intent);
    }

    public  void quizcapital(View view){
        Intent intent = new Intent(Anasayfa.this, CapitalActivity.class);
        startActivity(intent);
    }
    public  void quizcountry (View view){
        Intent intent = new Intent(Anasayfa.this, CountryActivity.class);
        startActivity(intent);
    }

    public  void quizflag(View view){
        Intent intent = new Intent(Anasayfa.this, FlagActivity.class);
        startActivity(intent);
    }

    public  void hScore(View view){
        Intent intent = new Intent(Anasayfa.this, HighScore.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Anasayfa.this, Anasayfa.class);
        startActivity(intent);

        super.onBackPressed();
    }
}
