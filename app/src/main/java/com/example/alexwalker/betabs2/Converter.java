package com.example.alexwalker.betabs2;

/**
 * Created by AlexWalker on 29.10.2016.
 */

public class Converter {


    public static String convertDay(int dayToConvert){
        String day = "";
        switch (dayToConvert){
            case 1:
                day = "Понедельник";
                break;
            case 2:
                day = "Вторник";
                break;
            case 3:
                day = "Среда";
                break;
            case 4:
                day = "Четверг";
                break;
            case 5:
                day = "Пятница";
                break;
            case 6:
                day = "Суббота";
                break;
        }
        return day;
    }
}
