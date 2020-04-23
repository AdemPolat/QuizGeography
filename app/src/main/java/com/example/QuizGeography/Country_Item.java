package com.example.QuizGeography;

public class Country_Item {

    String name;
    String country;
    public Country_Item(String name,String country){

        this.name = name;
        this.country=country;
    }

    public  String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }
}
