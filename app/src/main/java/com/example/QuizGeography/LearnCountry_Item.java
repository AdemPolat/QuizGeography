package com.example.QuizGeography;

public class LearnCountry_Item {

    String name;
    int image;
    public LearnCountry_Item(String name, int image){

        this.name = name;
        this.image=image;
    }

    public  String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }
}
