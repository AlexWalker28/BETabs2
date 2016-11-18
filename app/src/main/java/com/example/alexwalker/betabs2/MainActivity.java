package com.example.alexwalker.betabs2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;

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
    private String numGr;

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

                numGr = groupNumber.getText().toString();
                new ListSubjectsTask().execute();





                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String lesName = lessonName.getText().toString();
                        Subject lessonName1 = new Subject();
                        // TODO query to get subject, query to get group
                        lessonName1.setFullName(lesName);







                        String lesNumber = lessonNumber.getText().toString();
                        String lesDay = weekDay.getText().toString();
                        String lesOrder = lessonOrder.getText().toString();
                        String grYear = groupYear.getText().toString();

                       /* String lesAddress = lessonAddress.getText().toString();
                        Address lessonAddress = new Address();
                        lessonAddress.setAddress(lesAddress);




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

                        Backendless.Persistence.save(group);*/


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

    private class ListSubjectsTask extends AsyncTask<Object, Object, Integer> {
        protected Integer doInBackground(Object... num) {

            String whereClause2 = "groupNumber = '"+ Integer.valueOf(numGr) +"'";

            BackendlessDataQuery dataQuery = new BackendlessDataQuery();
            dataQuery.setWhereClause(whereClause2);

            BackendlessCollection<Group> result2 = Backendless.Persistence.of(Group.class).find(dataQuery);
            Integer groupNum1 = result2.getData().get(0).getGroupNumber();

            return groupNum1;
        }

        protected void onProgressUpdate(Object... progress) {

        }

        protected void onPostExecute(Integer result) {

            Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

        }


    }
}
