package com.example.alexwalker.betabs2;

/**
 * Created by AlexWalker on 29.10.2016.
 */


public class LessonComparator implements java.util.Comparator<Lesson> {

    @Override
    public int compare(Lesson t1, Lesson t2) {
        int value1 = (t1.getWeek().getDayOfTheWeek()).compareTo(t2.getWeek().getDayOfTheWeek());
        if (value1 == 0) {
            int value2 = t2.getLessonNumber().getNumber().compareTo(t2.getLessonNumber().getNumber());
          /*  if (value2 == 0) {
                return (t1.getLessonOrder()).compareTo(t2.getLessonOrder());
            }*/
            return value2;
        }
        return value1;

    }
}


