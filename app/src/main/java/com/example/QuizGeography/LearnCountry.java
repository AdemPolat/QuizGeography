package com.example.QuizGeography;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LearnCountry extends AppCompatActivity {

    TextView textUlke;
    TextView textBaskent;
    Button b_answer1,b_answer2,b_answer3,b_answer4;
    ImageView iv_flag;
    List<LearnCountry_Item> list;
    Random r;
    int turn =1;
    CountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_country);


        textUlke= findViewById(R.id.textUlke);
        textBaskent= findViewById(R.id.textBaskent);
        r= new Random();
        iv_flag = findViewById(R.id.iv_flag);
        b_answer1=findViewById(R.id.b_answer1);
        b_answer2=findViewById(R.id.b_answer2);
        b_answer3=findViewById(R.id.b_answer3);
        b_answer4=findViewById(R.id.b_answer4);

        list = new ArrayList<>();
        for(int i = 0; i< new LearnCountry_Database().answers.length; i++){

            list.add(new LearnCountry_Item(new LearnCountry_Database().answers[i],new LearnCountry_Database().flags[i]));
        }

        Collections.shuffle(list);
        newQuestions(turn);

        timer();

    }

    private void newQuestions(int number ){

        iv_flag.setImageResource(list.get(number-1).getImage());

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

    public void next(View view){

        textUlke.setVisibility(View.INVISIBLE);
        textBaskent.setVisibility(View.INVISIBLE);


        iv_flag.setVisibility(View.VISIBLE);

        turn++;
        newQuestions(turn);

        timer();


    }

    public  void timer(){
        myCountDownTimer = new CountDownTimer(2000,1000) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

                if(millisUntilFinished <= 1000){
                    if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

                        String c_answer1 = b_answer1.getText().toString();
                        textUlke.setText(c_answer1);
                    }
                    else if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                        String c_answer2 = b_answer2.getText().toString();
                        textUlke.setText(c_answer2);
                    }
                    else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                        String c_answer3 = b_answer3.getText().toString();
                        textUlke.setText(c_answer3);
                    }
                    else if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                        String c_answer4 = b_answer4.getText().toString();
                        textUlke.setText(c_answer4);
                    }

                    Animation blink = AnimationUtils.loadAnimation(LearnCountry.this,R.anim.blink);
                    textUlke.startAnimation(blink);
                    textUlke.setVisibility(View.VISIBLE);


                }
            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                viewBaskent();
                Animation blink = AnimationUtils.loadAnimation(LearnCountry.this,R.anim.blink);
                textBaskent.startAnimation(blink);
                textBaskent.setVisibility(View.VISIBLE);


            }
        }.start();
    }
    public void viewBaskent(){


        if(textUlke.getText().toString().matches("avusturya")){  textBaskent.setText("Viyana");  }
        else if(textUlke.getText().toString().matches("abd")){  textBaskent.setText("Washington D.C.");  }
        else if(textUlke.getText().toString().matches("afganistan")){  textBaskent.setText("Kabil");  }
        else if(textUlke.getText().toString().matches("almanya")){  textBaskent.setText("Berlin");  }
        else if(textUlke.getText().toString().matches("andorra")){  textBaskent.setText("Andorra le Vella");  }
        else if(textUlke.getText().toString().matches("angola")){  textBaskent.setText("Luanda");  }
        else if(textUlke.getText().toString().matches("antigua ve barbuda")){  textBaskent.setText("St John");  }
        else if(textUlke.getText().toString().matches("arjantin")){  textBaskent.setText("Buenos Aires");  }
        else if(textUlke.getText().toString().matches("arnavutluk")){  textBaskent.setText("Tiran");  }
        else if(textUlke.getText().toString().matches("avusturalya")){  textBaskent.setText("Canberra");  }

        else if(textUlke.getText().toString().matches("azerbaycan")){  textBaskent.setText("Bakü");  }
        else if(textUlke.getText().toString().matches("bahama adaları")){  textBaskent.setText("Nassau");  }
        else if(textUlke.getText().toString().matches("bahreyn")){  textBaskent.setText("Manama");  }
        else if(textUlke.getText().toString().matches("bangladeş")){  textBaskent.setText("Dakka");  }
        else if(textUlke.getText().toString().matches("barbados")){  textBaskent.setText("Bridgetown");  }
        else if(textUlke.getText().toString().matches("batı sahra")){  textBaskent.setText("Laayoune");  }
        else if(textUlke.getText().toString().matches("belarus")){  textBaskent.setText("Minsk");  }
        else if(textUlke.getText().toString().matches("belçika")){  textBaskent.setText("Brüksel");  }
        else if(textUlke.getText().toString().matches("belize")){  textBaskent.setText("Belmopan");  }
        else if(textUlke.getText().toString().matches("benin")){  textBaskent.setText("Porto- Novo");  }

        else if(textUlke.getText().toString().matches("bhutan")){  textBaskent.setText("Thimphu");  }
        else if(textUlke.getText().toString().matches("birlesik arap emirlikleri")){  textBaskent.setText("Abu Dabi");  }
        else if(textUlke.getText().toString().matches("bolivya")){  textBaskent.setText("Sucre");  }
        else if(textUlke.getText().toString().matches("bosna hersek")){  textBaskent.setText("Saraybosna");  }
        else if(textUlke.getText().toString().matches("botsvana")){  textBaskent.setText("Gaborone");  }
        else if(textUlke.getText().toString().matches("brezilya")){  textBaskent.setText("Brasillia");  }
        else if(textUlke.getText().toString().matches("brunei")){  textBaskent.setText("Bandar Seri Begawan");  }
        else if(textUlke.getText().toString().matches("bulgaristan")){  textBaskent.setText("Sofya");  }
        else if(textUlke.getText().toString().matches("burkina faso")){  textBaskent.setText("Ouagadougou");  }
        else if(textUlke.getText().toString().matches("burundi")){  textBaskent.setText("Bujumbura");  }

        else if(textUlke.getText().toString().matches("çekya")){  textBaskent.setText("Prag");  }
        else if(textUlke.getText().toString().matches("cezayir")){  textBaskent.setText("Cezayir");  }
        else if(textUlke.getText().toString().matches("cibuti")){  textBaskent.setText("Cibuti");  }
        else if(textUlke.getText().toString().matches("çin halk cumhuriyeti")){  textBaskent.setText("Pekin");  }
        else if(textUlke.getText().toString().matches("danimarka")){  textBaskent.setText("Kopenhag");  }
        else if(textUlke.getText().toString().matches("demokratik kongo cum.")){  textBaskent.setText("Kinshasa");  }
        else if(textUlke.getText().toString().matches("doğu timor")){  textBaskent.setText("Dili");  }
        else if(textUlke.getText().toString().matches("dominika")){  textBaskent.setText("Roseau");  }
        else if(textUlke.getText().toString().matches("dominik cumhuriyeti")){  textBaskent.setText("Santo Domingo");  }
        else if(textUlke.getText().toString().matches("ekvador")){  textBaskent.setText("Quito");  }

        else if(textUlke.getText().toString().matches("endonezya")){  textBaskent.setText("Jakarta");  }
        else if(textUlke.getText().toString().matches("eritre")){  textBaskent.setText("Asmara");  }
        else if(textUlke.getText().toString().matches("ermenistan")){  textBaskent.setText("Erivan");  }
        else if(textUlke.getText().toString().matches("estonya")){  textBaskent.setText("Tallinn");  }
        else if(textUlke.getText().toString().matches("etiyopya")){  textBaskent.setText("Addis Ababa");  }
        else if(textUlke.getText().toString().matches("fiji")){  textBaskent.setText("Suva");  }
        else if(textUlke.getText().toString().matches("fildişi sahilleri")){  textBaskent.setText("Yamoussoukro");  }
        else if(textUlke.getText().toString().matches("filipinler")){  textBaskent.setText("Manila");  }
        else if(textUlke.getText().toString().matches("finlandiya")){  textBaskent.setText("Helsinki");  }
        else if(textUlke.getText().toString().matches("fransa")){  textBaskent.setText("Paris");  }

        else if(textUlke.getText().toString().matches("gabon")){  textBaskent.setText("Libreville");  }
        else if(textUlke.getText().toString().matches("gambiya")){  textBaskent.setText("Banjul");  }
        else if(textUlke.getText().toString().matches("gana")){  textBaskent.setText("Accra");  }
        else if(textUlke.getText().toString().matches("gine")){  textBaskent.setText("Conakry");  }
        else if(textUlke.getText().toString().matches("gine bissau")){  textBaskent.setText("Bissau");  }
        else if(textUlke.getText().toString().matches("greneda")){  textBaskent.setText("St George’s");  }
        else if(textUlke.getText().toString().matches("guatemala")){  textBaskent.setText("Guatemala City");  }
        else if(textUlke.getText().toString().matches("güney afrika")){  textBaskent.setText("Pretoria");  }
        else if(textUlke.getText().toString().matches("güney kore")){  textBaskent.setText("Seul");  }
        else if(textUlke.getText().toString().matches("gürcistan")){  textBaskent.setText("Tiflis");  }

        else if(textUlke.getText().toString().matches("guyana")){  textBaskent.setText("Georgetown");  }
        else if(textUlke.getText().toString().matches("haiti")){  textBaskent.setText("Port-au -Prince");  }
        else if(textUlke.getText().toString().matches("hindistan")){  textBaskent.setText("Yeni Delhi");  }
        else if(textUlke.getText().toString().matches("hırvatistan")){  textBaskent.setText("Zagreb");  }
        else if(textUlke.getText().toString().matches("hollanda")){  textBaskent.setText("Amsterdam");  }
        else if(textUlke.getText().toString().matches("honduras")){  textBaskent.setText("Tegucigalpa");  }
        else if(textUlke.getText().toString().matches("ingiltere")){  textBaskent.setText("Londra");  }
        else if(textUlke.getText().toString().matches("ırak")){  textBaskent.setText("Bağdat");  }
        else if(textUlke.getText().toString().matches("iran")){  textBaskent.setText("Tahran");  }
        else if(textUlke.getText().toString().matches("irlanda")){  textBaskent.setText("Dublin");  }

        else if(textUlke.getText().toString().matches("ispanya")){  textBaskent.setText("Madrid");  }
        else if(textUlke.getText().toString().matches("israil")){  textBaskent.setText("Tel Aviv");  }
        else if(textUlke.getText().toString().matches("isveç")){  textBaskent.setText("Stockholm");  }
        else if(textUlke.getText().toString().matches("isviçre")){  textBaskent.setText("Bern");  }
        else if(textUlke.getText().toString().matches("italya")){  textBaskent.setText("Roma");  }
        else if(textUlke.getText().toString().matches("izlanda")){  textBaskent.setText("Reykjavik");  }
        else if(textUlke.getText().toString().matches("jamaika")){  textBaskent.setText("Kingston");  }
        else if(textUlke.getText().toString().matches("japonya")){  textBaskent.setText("Tokyo");  }
        else if(textUlke.getText().toString().matches("kamboçya")){  textBaskent.setText("Phnom Penh");  }
        else if(textUlke.getText().toString().matches("kamerun")){  textBaskent.setText("Yaoundé");  }

        else if(textUlke.getText().toString().matches("kanada")){  textBaskent.setText("Ottawa");  }
        else if(textUlke.getText().toString().matches("karadağ")){  textBaskent.setText("Podgorica");  }
        else if(textUlke.getText().toString().matches("katar")){  textBaskent.setText("Doha");  }
        else if(textUlke.getText().toString().matches("kazakistan")){  textBaskent.setText("Astana");  }
        else if(textUlke.getText().toString().matches("kenya")){  textBaskent.setText("Nairobi");  }
        else if(textUlke.getText().toString().matches("kıbrıs")){  textBaskent.setText("Nicosia");  }
        else if(textUlke.getText().toString().matches("kırgızistan")){  textBaskent.setText("Bişkek");  }
        else if(textUlke.getText().toString().matches("kiribati")){  textBaskent.setText("Bairiki");  }
        else if(textUlke.getText().toString().matches("kolombiya")){  textBaskent.setText("Bogota");  }
        else if(textUlke.getText().toString().matches("komorlar")){  textBaskent.setText("Moroni");  }

        else if(textUlke.getText().toString().matches("kongo demokratik cum.")){  textBaskent.setText("Brazzaville");  }
        else if(textUlke.getText().toString().matches("kosova")){  textBaskent.setText("Priştine");  }
        else if(textUlke.getText().toString().matches("kosta rika")){  textBaskent.setText("San José");  }
        else if(textUlke.getText().toString().matches("küba")){  textBaskent.setText("Havana");  }
        else if(textUlke.getText().toString().matches("kuveyt")){  textBaskent.setText("Kuveyt");  }
        else if(textUlke.getText().toString().matches("kuzey kore")){  textBaskent.setText("Pyongyang ");  }
        else if(textUlke.getText().toString().matches("laos")){  textBaskent.setText("Vientiane");  }
        else if(textUlke.getText().toString().matches("lesotho")){  textBaskent.setText("Maseru");  }
        else if(textUlke.getText().toString().matches("letonya")){  textBaskent.setText("Riga");  }
        else if(textUlke.getText().toString().matches("liberya")){  textBaskent.setText("Monrovia");  }

        else if(textUlke.getText().toString().matches("libya")){  textBaskent.setText("Tripoli");  }
        else if(textUlke.getText().toString().matches("liechtenstein")){  textBaskent.setText("Vaduz");  }
        else if(textUlke.getText().toString().matches("litvanya")){  textBaskent.setText("Vilnius");  }
        else if(textUlke.getText().toString().matches("lübnan")){  textBaskent.setText("Beyrut");  }
        else if(textUlke.getText().toString().matches("lucia")){  textBaskent.setText("Castries");  }
        else if(textUlke.getText().toString().matches("lüksemburg")){  textBaskent.setText("Lüksemburg");  }
        else if(textUlke.getText().toString().matches("macaristan")){  textBaskent.setText("Budapeşte");  }
        else if(textUlke.getText().toString().matches("madagaskar")){  textBaskent.setText("Antananarivo");  }
        else if(textUlke.getText().toString().matches("makedonya")){  textBaskent.setText("Üsküp");  }
        else if(textUlke.getText().toString().matches("malavi")){  textBaskent.setText("Lilongwe");  }

        else if(textUlke.getText().toString().matches("maldivler")){  textBaskent.setText("Male");  }
        else if(textUlke.getText().toString().matches("malezya")){  textBaskent.setText("Kuala Lumpur");  }
        else if(textUlke.getText().toString().matches("mali")){  textBaskent.setText("Bamako");  }
        else if(textUlke.getText().toString().matches("malta")){  textBaskent.setText("Valletta");  }
        else if(textUlke.getText().toString().matches("marshall adaları")){  textBaskent.setText("Majuro");  }
        else if(textUlke.getText().toString().matches("mauritius")){  textBaskent.setText("Port Louis");  }
        else if(textUlke.getText().toString().matches("meksika")){  textBaskent.setText("Meksiko");  }
        else if(textUlke.getText().toString().matches("mikronezya")){  textBaskent.setText("Palikir");  }
        else if(textUlke.getText().toString().matches("mısır")){  textBaskent.setText("Kahire");  }
        else if(textUlke.getText().toString().matches("moğolistan")){  textBaskent.setText("Ulan Batur");  }

        else if(textUlke.getText().toString().matches("moldova")){  textBaskent.setText("Chisinau");  }
        else if(textUlke.getText().toString().matches("monako")){  textBaskent.setText("Monako");  }
        else if(textUlke.getText().toString().matches("moritanya")){  textBaskent.setText("Nouakchott");  }
        else if(textUlke.getText().toString().matches("mozambik")){  textBaskent.setText("Maputo");  }
        else if(textUlke.getText().toString().matches("nabipya")){  textBaskent.setText("Windhoek");  }
        else if(textUlke.getText().toString().matches("nauru")){  textBaskent.setText("Yaren");  }
        else if(textUlke.getText().toString().matches("nepal")){  textBaskent.setText("Katmandu");  }
        else if(textUlke.getText().toString().matches("nijer")){  textBaskent.setText("Niamey");  }
        else if(textUlke.getText().toString().matches("nijerya")){  textBaskent.setText("Abuja");  }
        else if(textUlke.getText().toString().matches("nikaragua")){  textBaskent.setText("Managua");  }

        else if(textUlke.getText().toString().matches("norvec")){  textBaskent.setText("Oslo");  }
        else if(textUlke.getText().toString().matches("umman")){  textBaskent.setText("Maskat");  }
        else if(textUlke.getText().toString().matches("orta afrika cum.")){  textBaskent.setText("Bangui");  }
        else if(textUlke.getText().toString().matches("özbekistan")){  textBaskent.setText("Taşkent");  }
        else if(textUlke.getText().toString().matches("pakistan")){  textBaskent.setText("İslamabad");  }
        else if(textUlke.getText().toString().matches("palau")){  textBaskent.setText("Ngerulmud");  }
        else if(textUlke.getText().toString().matches("panama")){  textBaskent.setText("Panama City");  }
        else if(textUlke.getText().toString().matches("papua yine gine")){  textBaskent.setText("Port Moresby");  }
        else if(textUlke.getText().toString().matches("paraguay")){  textBaskent.setText("Asunción");  }
        else if(textUlke.getText().toString().matches("peru")){  textBaskent.setText("Lima");  }

        else if(textUlke.getText().toString().matches("polonya")){  textBaskent.setText("Varşova");  }
        else if(textUlke.getText().toString().matches("portekiz")){  textBaskent.setText("Lizbon");  }
        else if(textUlke.getText().toString().matches("romanya")){  textBaskent.setText("Bükreş");  }
        else if(textUlke.getText().toString().matches("ruanda")){  textBaskent.setText("Kigali");  }
        else if(textUlke.getText().toString().matches("rusya federasyonu")){  textBaskent.setText("Moskova");  }
        else if(textUlke.getText().toString().matches("Saint nevis")){  textBaskent.setText("Basseterre");  }
        else if(textUlke.getText().toString().matches("samoa")){  textBaskent.setText("Apia");  }
        else if(textUlke.getText().toString().matches("san marino")){  textBaskent.setText("San Marino");  }
        else if(textUlke.getText().toString().matches("sao tome")){  textBaskent.setText("Sao Tome");  }
        else if(textUlke.getText().toString().matches("senegal")){  textBaskent.setText("Dakar");  }

        else if(textUlke.getText().toString().matches("seyşeller")){  textBaskent.setText("Victoria");  }
        else if(textUlke.getText().toString().matches("sierra leone")){  textBaskent.setText("Freetown");  }
        else if(textUlke.getText().toString().matches("şili")){  textBaskent.setText("Santiago");  }
        else if(textUlke.getText().toString().matches("singapur")){  textBaskent.setText("Singapur");  }
        else if(textUlke.getText().toString().matches("sırbistan")){  textBaskent.setText("Belgrat");  }
        else if(textUlke.getText().toString().matches("slovakya")){  textBaskent.setText("Bratislava");  }
        else if(textUlke.getText().toString().matches("slovenya")){  textBaskent.setText("Ljubljana");  }
        else if(textUlke.getText().toString().matches("solomon adaları")){  textBaskent.setText("Honiara");  }
        else if(textUlke.getText().toString().matches("somali")){  textBaskent.setText("Mogadişu");  }
        else if(textUlke.getText().toString().matches("sri lanka")){  textBaskent.setText("Colombo");  }

        else if(textUlke.getText().toString().matches("St vincent")){  textBaskent.setText("Managua");  }
        else if(textUlke.getText().toString().matches("Sudan")){  textBaskent.setText("Hartum");  }
        else if(textUlke.getText().toString().matches("surinam")){  textBaskent.setText("Paramaribo");  }
        else if(textUlke.getText().toString().matches("suriye")){  textBaskent.setText("Şam");  }
        else if(textUlke.getText().toString().matches("suudi arabistan")){  textBaskent.setText("Riyad");  }
        else if(textUlke.getText().toString().matches("swaziland")){  textBaskent.setText("Mbabane");  }
        else if(textUlke.getText().toString().matches("tacikistan")){  textBaskent.setText("Duşanbe");  }
        else if(textUlke.getText().toString().matches("tanzanya")){  textBaskent.setText("Dodoma");  }
        else if(textUlke.getText().toString().matches("tayland")){  textBaskent.setText("Bangkok");  }
        else if(textUlke.getText().toString().matches("tobago")){  textBaskent.setText("Port of Spain");  }

        else if(textUlke.getText().toString().matches("togo")){  textBaskent.setText("Lomé");  }
        else if(textUlke.getText().toString().matches("tonga")){  textBaskent.setText("Nuku’alofa");  }
        else if(textUlke.getText().toString().matches("tunus")){  textBaskent.setText("Tunus");  }
        else if(textUlke.getText().toString().matches("türkiye")){  textBaskent.setText("Ankara");  }
        else if(textUlke.getText().toString().matches("türkmenistan")){  textBaskent.setText("Aşkabat");  }
        else if(textUlke.getText().toString().matches("tuvalu")){  textBaskent.setText("Funafuti");  }
        else if(textUlke.getText().toString().matches("uganda")){  textBaskent.setText("Kampala");  }
        else if(textUlke.getText().toString().matches("ukrayna")){  textBaskent.setText("Kiev");  }
        else if(textUlke.getText().toString().matches("ürdün")){  textBaskent.setText("Amman");  }
        else if(textUlke.getText().toString().matches("uruguay")){  textBaskent.setText("Montevideo");  }

        else if(textUlke.getText().toString().matches("vanuatu")){  textBaskent.setText("Port Vila");  }
        else if(textUlke.getText().toString().matches("vatikan")){  textBaskent.setText("Vatikan");  }
        else if(textUlke.getText().toString().matches("venezuela")){  textBaskent.setText("Karakas");  }
        else if(textUlke.getText().toString().matches("vietnam")){  textBaskent.setText("Hanoi");  }
        else if(textUlke.getText().toString().matches("yemen")){  textBaskent.setText("Sanaa");  }
        else if(textUlke.getText().toString().matches("yeni zelanda")){  textBaskent.setText("Wellington");  }
        else if(textUlke.getText().toString().matches("yeşil burun adaları")){  textBaskent.setText("Praia");  }
        else if(textUlke.getText().toString().matches("yunanistan")){  textBaskent.setText("Atina");  }
        else if(textUlke.getText().toString().matches("zambia")){  textBaskent.setText("Lusaka");  }
        else if(textUlke.getText().toString().matches("zimbabwe")){  textBaskent.setText("Harare");  }

    }
}


