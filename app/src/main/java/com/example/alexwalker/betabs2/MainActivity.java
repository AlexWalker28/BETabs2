package com.example.alexwalker.betabs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity {

    Button changeLayout;
    Button addLessonButton;
    Button clearButton;
    AutoCompleteTextView lessonFaculty;
    EditText lessonCourse;
    EditText lessonGroup;
    AutoCompleteTextView lessonName;
    EditText lessonNumber;
    AutoCompleteTextView lessonAddress;
    AutoCompleteTextView weekDay;
    EditText lessonOrder;

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
                        LessonName lessonName1 = new LessonName();
                        lessonName1.setFullName(lesName);

                        String lesNumber = lessonNumber.getText().toString();
                        LessonNumber lessonNumber = new LessonNumber();
                        lessonNumber.setNumber(lesNumber);

                        String lesAddress = lessonAddress.getText().toString();
                        Address lessonAddress = new Address();
                        lessonAddress.setAddress(lesAddress);

                        String lesDay = weekDay.getText().toString();
                        Week week = new Week();
                        week.setDayOfTheWeek(Converter.convertDayToInteger(lesDay));

                        String lesOrder = lessonOrder.getText().toString();
                        LessonOrder lessonOrder = new LessonOrder();
                        lessonOrder.setOrder(Integer.valueOf(lesOrder));

                        Lesson lesson = new Lesson();
                        lesson.setLessonName(lessonName1);
                        lesson.setLessonNumber(lessonNumber);
                        lesson.setLessonAddress(lessonAddress);
                        lesson.setWeek(week);
                        lesson.setLessonOrder(lessonOrder);
                        Backendless.Persistence.save(lesson);


                    }
                }).start();


            }
        });


    }


    private void initVars() {

        lessonFaculty = (AutoCompleteTextView) findViewById(R.id.lessonFaculty1);
        lessonCourse = (EditText) findViewById(R.id.lessonCourse1);
        lessonGroup = (EditText) findViewById(R.id.lessonGroup1);
        lessonName = (AutoCompleteTextView) findViewById(R.id.lessonName1);
        lessonNumber = (EditText) findViewById(R.id.lessonNumber1);
        lessonAddress = (AutoCompleteTextView) findViewById(R.id.lessonAddress1);
        weekDay = (AutoCompleteTextView) findViewById(R.id.weekDay1);
        lessonOrder = (EditText) findViewById(R.id.lessonOrder1);
        addLessonButton = (Button) findViewById(R.id.addButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        changeLayout = (Button) findViewById(R.id.change);


    }
}
