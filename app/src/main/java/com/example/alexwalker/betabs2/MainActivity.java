package com.example.alexwalker.betabs2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.backendless.Backendless;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Button changeLayout;
    Button addLessonButton;
    Button clearButton;
    AutoCompleteTextView lessonFaculty;
    EditText groupYear;
    EditText groupNumber;
    AutoCompleteTextView lessonName;
    EditText lessonNumber;
    AutoCompleteTextView lessonAddress;
    AutoCompleteTextView weekDay;
    EditText lessonOrder;
    Switch isLecture;
    Switch isOdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appVersion = "v1";
        Backendless.initApp(this, "ECD9BE7E-78DD-4F01-FF4E-EE88E8026F00", "9B5BC839-0646-3D7B-FF78-5662E53A0200", appVersion);

        initVars();

        changeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


        final ArrayAdapter<CharSequence> facultyAdapter = ArrayAdapter.createFromResource(this, R.array.Faculty, R.layout.support_simple_spinner_dropdown_item);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> nameAdapter = ArrayAdapter.createFromResource(this, R.array.Subjects, R.layout.support_simple_spinner_dropdown_item);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> addressAdapter = ArrayAdapter.createFromResource(this, R.array.Addresses, R.layout.support_simple_spinner_dropdown_item);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.Week, R.layout.support_simple_spinner_dropdown_item);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        lessonFaculty.setAdapter(facultyAdapter);
        lessonFaculty.setThreshold(1);
        lessonName.setAdapter(nameAdapter);
        lessonName.setThreshold(1);
        lessonAddress.setAdapter(addressAdapter);
        lessonAddress.setThreshold(1);
        weekDay.setAdapter(dayAdapter);
        weekDay.setThreshold(1);


        addLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String lesName = lessonName.getText().toString();
                        Subject lessonName1 = new Subject();
                        lessonName1.setFullName(lesName);

                        String lesNumber = lessonNumber.getText().toString();
                        String lesDay = weekDay.getText().toString();
                        String lesOrder = lessonOrder.getText().toString();
                        String grYear = groupYear.getText().toString();

                        String lesAddress = lessonAddress.getText().toString();
                        Address lessonAddress = new Address();
                        lessonAddress.setAddress(lesAddress);


                        List<Lesson> lessonList = new List<Lesson>() {
                            @Override
                            public int size() {
                                return 0;
                            }

                            @Override
                            public boolean isEmpty() {
                                return false;
                            }

                            @Override
                            public boolean contains(Object o) {
                                return false;
                            }

                            @NonNull
                            @Override
                            public Iterator<Lesson> iterator() {
                                return null;
                            }

                            @NonNull
                            @Override
                            public Object[] toArray() {
                                return new Object[0];
                            }

                            @NonNull
                            @Override
                            public <T> T[] toArray(T[] ts) {
                                return null;
                            }

                            @Override
                            public boolean add(Lesson lesson) {
                                return false;
                            }

                            @Override
                            public boolean remove(Object o) {
                                return false;
                            }

                            @Override
                            public boolean containsAll(Collection<?> collection) {
                                return false;
                            }

                            @Override
                            public boolean addAll(Collection<? extends Lesson> collection) {
                                return false;
                            }

                            @Override
                            public boolean addAll(int i, Collection<? extends Lesson> collection) {
                                return false;
                            }

                            @Override
                            public boolean removeAll(Collection<?> collection) {
                                return false;
                            }

                            @Override
                            public boolean retainAll(Collection<?> collection) {
                                return false;
                            }

                            @Override
                            public void clear() {

                            }

                            @Override
                            public Lesson get(int i) {
                                return null;
                            }

                            @Override
                            public Lesson set(int i, Lesson lesson) {
                                return null;
                            }

                            @Override
                            public void add(int i, Lesson lesson) {

                            }

                            @Override
                            public Lesson remove(int i) {
                                return null;
                            }

                            @Override
                            public int indexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public int lastIndexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public ListIterator<Lesson> listIterator() {
                                return null;
                            }

                            @NonNull
                            @Override
                            public ListIterator<Lesson> listIterator(int i) {
                                return null;
                            }

                            @NonNull
                            @Override
                            public List<Lesson> subList(int i, int i1) {
                                return null;
                            }
                        };

                        Lesson lesson = new Lesson();
                        lesson.setLessonName(lessonName1);
                        lesson.setNumber(Integer.valueOf(lesNumber));
                        lesson.setLessonAddress(lessonAddress);
                        lesson.setDayOfWeek(Integer.valueOf(lesDay));
                        lesson.setOrder(Integer.valueOf(lesOrder));
                        lesson.setYear(Integer.valueOf(grYear));
                        if (isLecture.isChecked()) lesson.setIsLecture(true);
                        if (isOdd.isChecked()) lesson.setIsOdd(true);

                        lessonList.add(lesson);

                        String lesFaculty = lessonFaculty.getText().toString();
                        Faculty faculty = new Faculty();
                        faculty.setFaculty(lesFaculty);


                        String groupNumberBE = groupNumber.getText().toString();
                        Group group = new Group();
                        group.setGroupFaculty(faculty);
                        group.setGroupNumber(Integer.valueOf(groupNumberBE));
                        group.setGroupLesson(lessonList);

                        Backendless.Persistence.save(group);


                    }
                }).start();


            }
        });


    }


    private void initVars() {

        lessonFaculty = (AutoCompleteTextView) findViewById(R.id.lessonFaculty1);
        groupYear = (EditText) findViewById(R.id.lessonCourse1);
        groupNumber = (EditText) findViewById(R.id.lessonGroup1);
        lessonName = (AutoCompleteTextView) findViewById(R.id.lessonName1);
        lessonNumber = (EditText) findViewById(R.id.lessonNumber1);
        lessonAddress = (AutoCompleteTextView) findViewById(R.id.lessonAddress1);
        weekDay = (AutoCompleteTextView) findViewById(R.id.weekDay1);
        lessonOrder = (EditText) findViewById(R.id.lessonOrder1);
        addLessonButton = (Button) findViewById(R.id.addButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        changeLayout = (Button) findViewById(R.id.change);
        isLecture = (Switch) findViewById(R.id.isLecture1);
        isOdd = (Switch) findViewById(R.id.isOdd1);

    }
}
