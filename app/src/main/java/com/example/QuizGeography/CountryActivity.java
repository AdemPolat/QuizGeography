package com.example.QuizGeography;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CountryActivity extends AppCompatActivity {

    String uCountryHigh1;
    String uCountryHigh2;
    String uCountryHigh3;

    MediaPlayer player;
    TextView textSeri;
    TextView kalanHak;
    Button timeButton;
    CountDownTimer myCountDownTimer;
    CountDownTimer btnCountDownTimer;

    SharedPreferences sharedPreferences;

    TextView textHigh1;
    TextView textHigh2;
    TextView textHigh3;

    TextView skipQuestion;
    TextView fiftyfiftybutton;
    int fifty=3;
    int skip=3;

    int kalanCan=3;
    int seri=0;

    TextView scoreText;
    int score=0;


    Button b_answer1,b_answer2,b_answer3,b_answer4;
    TextView iv_country;
    List<Country_Item> list;
    Random r;
    int turn =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countryactivity);

        scoreText = findViewById(R.id.scoreText);
        kalanHak= findViewById(R.id.kalanHak);
        timeButton= findViewById(R.id.timebutton);
        skipQuestion= findViewById(R.id.skipQuestion);
        fiftyfiftybutton= findViewById(R.id.fiftyfiftybutton);

        textHigh1 = findViewById(R.id.textFlagHigh1);
        textHigh2 = findViewById(R.id.textFlagHigh2);
        textHigh3 = findViewById(R.id.textCountryHigh3);
        sharedPreferences =this.getSharedPreferences("com.example.QuizGeography", Context.MODE_PRIVATE);
        int StoredScore7 = sharedPreferences.getInt("StoredScore7", 0);
        int StoredScore8 = sharedPreferences.getInt("StoredScore8", 0);
        int StoredScore9 = sharedPreferences.getInt("StoredScore9", 0);
        textHigh1.setText(""+StoredScore7);
        textHigh2.setText(""+StoredScore8);
        textHigh3.setText(""+StoredScore9);

        r= new Random();
        iv_country = findViewById(R.id.iv_flag);
        b_answer1=findViewById(R.id.b_answer1);
        b_answer2=findViewById(R.id.b_answer2);
        b_answer3=findViewById(R.id.b_answer3);
        b_answer4=findViewById(R.id.b_answer4);

        list = new ArrayList<>();

        for(int i = 0; i< new Country_Database().answers.length; i++){



            list.add(new Country_Item(new Country_Database().answers[i],new Country_Database().country[i]));
        }

        Collections.shuffle(list);
        newQuestions(turn);

        myCountDownTimer = new CountDownTimer(90000,1000) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {
                timeButton.setText(""+ millisUntilFinished/1000);
                timeButton.setTextColor(Color.WHITE);

                if(millisUntilFinished <= 6000){
                    timeButton.setTextColor(Color.RED);

                    Vibrator titresim = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    titresim.vibrate(100);
                }
            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                gameOver();

            }
        }.start();
    }

    public void answer1(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            truebutton();
            b_answer1.setBackgroundResource(R.drawable.uibuttongreen);


        } else {

            wrongbutton();
            b_answer1.setBackgroundResource(R.drawable.uibuttonred);
            b_answer1.setEnabled(false);

            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer2.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer3.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else{
                b_answer4.setBackgroundResource(R.drawable.uibuttongreen);
            }

        }

    }

    public void answer2(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            truebutton();
            b_answer2.setBackgroundResource(R.drawable.uibuttongreen);


        } else{

            wrongbutton();
            b_answer2.setBackgroundResource(R.drawable.uibuttonred);
            b_answer2.setEnabled(false);

            if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer1.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer3.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else{
                b_answer4.setBackgroundResource(R.drawable.uibuttongreen);
            }

        }
    }

    public void answer3(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            truebutton();
            b_answer3.setBackgroundResource(R.drawable.uibuttongreen);


        } else {

            wrongbutton();
            b_answer3.setBackgroundResource(R.drawable.uibuttonred);
            b_answer3.setEnabled(false);

            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer2.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer1.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else{
                b_answer4.setBackgroundResource(R.drawable.uibuttongreen);
            }


        }
    }

    public void answer4(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            truebutton();
            b_answer4.setBackgroundResource(R.drawable.uibuttongreen);

        } else{

            wrongbutton();
            b_answer4.setBackgroundResource(R.drawable.uibuttonred);
            b_answer4.setEnabled(false);

            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer2.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer3.setBackgroundResource(R.drawable.uibuttongreen);
            }
            else{
                b_answer1.setBackgroundResource(R.drawable.uibuttongreen);
            }


        }
    }

    private void newQuestions(int number ){

        iv_country.setText(list.get(number-1).getCountry());

        int correct_answer = r.nextInt(4) + 1;

        int firstButton= number - 1;
        int secondButton= number;
        int thirdButton= number;
        int fourthButton= number;

        switch (correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());


                break;
            case 2:

                b_answer2.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:

                b_answer3.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:

                b_answer4.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(fourthButton).getName());
                break;

        }
    }

    public void gameOver(){

        int hScore = Integer.parseInt(textHigh1.getText().toString());
        int hScore2 = Integer.parseInt(textHigh2.getText().toString());
        int hScore3 = Integer.parseInt(textHigh3.getText().toString());

        if(score >= hScore){

            hScore3=hScore2;
            hScore2=hScore;
            hScore=score;

            textHigh1.setText("" + hScore);
            textHigh2.setText("" + hScore2);
            textHigh3.setText("" + hScore3);
            sharedPreferences.edit().putInt("StoredScore7",hScore).apply();
            sharedPreferences.edit().putInt("StoredScore8",hScore2).apply();
            sharedPreferences.edit().putInt("StoredScore9",hScore3).apply();

        }
        else if(score < hScore && score >= hScore2){

            hScore3=hScore2;
            hScore2=score;

            textHigh1.setText("" + hScore);
            textHigh2.setText("" + hScore2);
            textHigh3.setText("" + hScore3);
            sharedPreferences.edit().putInt("StoredScore7",hScore).apply();
            sharedPreferences.edit().putInt("StoredScore8",hScore2).apply();
            sharedPreferences.edit().putInt("StoredScore9",hScore3).apply();



        }
        else if(score < hScore && score < hScore2 && score > hScore3){

            hScore3=score;

            textHigh1.setText("" + hScore);
            textHigh2.setText("" + hScore2);
            textHigh3.setText("" + hScore3);
            sharedPreferences.edit().putInt("StoredScore7",hScore).apply();
            sharedPreferences.edit().putInt("StoredScore8",hScore2).apply();
            sharedPreferences.edit().putInt("StoredScore9",hScore3).apply();

        }

        uCountryHigh1= textHigh1.getText().toString(); // GET INTENT
        uCountryHigh2= textHigh2.getText().toString();
        uCountryHigh3= textHigh3.getText().toString();
        Intent intent = new Intent(CountryActivity.this, HighScore.class);
        intent.putExtra("userCountryHigh1",uCountryHigh1);
        intent.putExtra("userCountryHigh2",uCountryHigh2);
        intent.putExtra("userCountryHigh3",uCountryHigh3);





        myCountDownTimer.cancel();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CountryActivity.this);
        alertDialogBuilder.setTitle("OYUN BİTTİ");
        alertDialogBuilder.setMessage("PUANINIZ: "+ score+"\n\nEn Yüksek Skor:"+hScore+ "\nEn Yüksek 2.Skor:"+hScore2 +"\nEn Yüksek 3.Skor:"+hScore3);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yeni Oyun", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(), CountryActivity.class));
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Anasayfaya Dön", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder alert = new AlertDialog.Builder(CountryActivity.this);  // Uyarı mesajını açar
        alert.setTitle("UYARI");
        alert.setMessage("Çıkmak istiyor musunuz?");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                myCountDownTimer.cancel();

                Intent intent = new Intent(CountryActivity.this, Anasayfa.class);
                startActivity(intent);
            }
        });

        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    public void skipQuestion(View view){

        turn++;
        newQuestions(turn);

        skip--;
        if(skip==3){
            skipQuestion.setText("Soruyu Atla(3)");
        }
        if(skip==2){
            skipQuestion.setText("Soruyu Atla(2)");
        }
        if(skip==1){
            skipQuestion.setText("Soruyu Atla(1)");
        }
        if(skip==0){
            skipQuestion.setText("Soruyu Atla(0)");
            skipQuestion.setTextColor(Color.GRAY);
            skipQuestion.setEnabled(false);
        }
    }

    public void fiftyfifty(View view){

        fiftyfiftybutton.setEnabled(false);



        if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            b_answer2.setVisibility(View.INVISIBLE);
            b_answer3.setVisibility(View.INVISIBLE);


        } else if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            b_answer1.setVisibility(View.INVISIBLE);
            b_answer4.setVisibility(View.INVISIBLE);

        } else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            b_answer1.setVisibility(View.INVISIBLE);
            b_answer4.setVisibility(View.INVISIBLE);

        } else if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            b_answer2.setVisibility(View.INVISIBLE);
            b_answer3.setVisibility(View.INVISIBLE);

        }
        fifty--;
        if(fifty==3){
            fiftyfiftybutton.setText("%50 Joker(3)");
        }
        if(fifty==2){
            fiftyfiftybutton.setText("%50 Joker(2)");
        }
        if(fifty==1){
            fiftyfiftybutton.setText("%50 Joker(1)");
        }
        if(fifty==0){
            fiftyfiftybutton.setText("%50 Joker(0)");
            fiftyfiftybutton.setTextColor(Color.GRAY);
            fiftyfiftybutton.setEnabled(false);
        }

    }

    public void wrongbutton(){


        seri = 0;

        Vibrator titresim = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        titresim.vibrate(100);

        kalanCan--;
        kalanHak.setText(""+kalanCan);

        player = MediaPlayer.create(this, R.raw.balloon);
        player.start();
        btnCountDownTimer = new CountDownTimer(1000,1000) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                turn++;
                newQuestions(turn);

                b_answer1.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer2.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer3.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer4.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer1.setEnabled(true);
                b_answer2.setEnabled(true);
                b_answer3.setEnabled(true);
                b_answer4.setEnabled(true);

            }
        }.start();


        if(kalanCan == 0){

            gameOver();
        }

        b_answer1.setVisibility(View.VISIBLE);
        b_answer2.setVisibility(View.VISIBLE);
        b_answer3.setVisibility(View.VISIBLE);
        b_answer4.setVisibility(View.VISIBLE);

        if(fifty > 0){

            fiftyfiftybutton.setEnabled(true);
        }
    }

    public void truebutton() {
        seri++;
        if(seri >=10){
            if (kalanCan < 3) {
                kalanCan++;
                kalanHak.setText(""+kalanCan);
                seri=0;
            } }

        score++;
        scoreText.setText(""+score);
        player = MediaPlayer.create(this, R.raw.seskayit);
        player.start();

        btnCountDownTimer = new CountDownTimer(500,500) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                turn++;
                newQuestions(turn);

                b_answer1.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer2.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer3.setBackgroundResource(R.drawable.uibuttonnormal);
                b_answer4.setBackgroundResource(R.drawable.uibuttonnormal);

                b_answer1.setEnabled(true);
                b_answer2.setEnabled(true);
                b_answer3.setEnabled(true);
                b_answer4.setEnabled(true);

            }
        }.start();


        b_answer1.setVisibility(View.VISIBLE);
        b_answer2.setVisibility(View.VISIBLE);
        b_answer3.setVisibility(View.VISIBLE);
        b_answer4.setVisibility(View.VISIBLE);

        if(fifty > 0){

            fiftyfiftybutton.setEnabled(true);
        }

    }
}