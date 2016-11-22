package com.example.alexwalker.betabs2;

public class Helper {

    public static Lesson check(Group group, int lesNum, int lesWeekDay, int lesOrder, boolean isOdd){
        Lesson lesson = null;

        for (Lesson less : group.getGroupLesson()) {
            if(lesNum == less.getNumber() &&
               lesWeekDay == less.getDayOfWeek() &&
               lesOrder == less.getOrder() &&
               isOdd == less.getIsOdd()){
                lesson = less;
                break;
            }
        }
        return lesson;

    }

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

    public static int convertDayToInteger(String dayToConvert){
        int day = 0;
        switch (dayToConvert){
            case "Понедельник":
                day = 1;
                break;
            case "Вторник":
                day = 2;
                break;
            case "Среда":
                day = 3;
                break;
            case "Четверг":
                day = 4;
                break;
            case "Пятница":
                day = 5;
                break;
            case "Суббота":
                day = 6;
                break;
        }
        return day;
    }

    public static String convertLessonNumber(String numberToConvert){
        String number = "";
        switch (numberToConvert){
            case "1":
                number = "7:30 - 9:05";
                break;
            case "2":
                number = "10:00 - 11:35";
                break;
            case "3":
                number = "12:15 - 13:50";
                break;
            case "4":
                number = "14:30 - 16:05";
                break;
            case "5":
                number = "7:00 - 9:15";
                break;
            case "6":
                number = "9:20 - 11:40";
                break;
            case "7":
                number = "12:15 - 14:35";
                break;
            case "8":
                number = "15:00 - 17:15";
        }
        return number;
    }



}
