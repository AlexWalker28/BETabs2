package com.example.alexwalker.betabs2;

/**
 * Created by ThirtySeven on 18.11.2016.
 */

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
}
