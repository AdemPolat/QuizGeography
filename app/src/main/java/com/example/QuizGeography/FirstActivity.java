package com.example.QuizGeography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;

public class FirstActivity extends AppCompatActivity {
    CountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);


        myCountDownTimer = new CountDownTimer(1000,1000) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                Intent intent=new Intent(FirstActivity.this,Anasayfa.class);
                startActivity(intent);

            }
        }.start();
    }
}
