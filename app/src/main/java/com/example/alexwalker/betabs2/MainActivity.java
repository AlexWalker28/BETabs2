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

    private Button changeLayout;
    private Button addLessonButton;
    private Button clearButton;
    private AutoCompleteTextView lessonFaculty;
    private EditText groupYear;
    private EditText groupNumber;
    private AutoCompleteTextView lessonName;
    private EditText lessonNumber;
    private AutoCompleteTextView lessonAddress;
    private AutoCompleteTextView weekDay;
    private EditText lessonOrder;
    private Switch isLecture;
    private Switch isOdd;
    private String numberOfGroup;
    private String lessonNameString;
    private String lessonAddressString;
    private String lesNumber;
    private String lesDay;
    private String lesOrder;
    private String lesFaculty;
    private String grYear;
    private Boolean odd;
    private Boolean lecture;
    private String lectureOrNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appVersion = "v1";
        Backendless.initApp(this, "ECD9BE7E-78DD-4F01-FF4E-EE88E8026F00", "9B5BC839-0646-3D7B-FF78-5662E53A0200", appVersion);

        initVars();
        lessonFaculty.setText("Лечебное дело");
        groupYear.setText("4");
        groupNumber.setText("27");
        lessonName.setText("Оперативная хирургия");
        lessonNumber.setText("1");
        lessonAddress.setText("НХЦ");
        weekDay.setText("Понедельник");
        lessonOrder.setText("1");


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

                numberOfGroup = groupNumber.getText().toString();
                lessonNameString = lessonName.getText().toString();
                lessonAddressString = lessonAddress.getText().toString();
                lesFaculty = lessonFaculty.getText().toString();
                lesNumber = lessonNumber.getText().toString();
                lesDay   = weekDay.getText().toString();
                lesOrder = lessonOrder.getText().toString();
                grYear   = groupYear.getText().toString();
                odd = isOdd.isChecked();
                lecture = isLecture.isChecked();


                new ListSubjectsTask().execute();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String lesName = lessonName.getText().toString();
                        Subject lessonName1 = new Subject();
                        // TODO query to get subject, query to get group
                        lessonName1.setFullName(lesName);
/*                        Lesson lesson = new Lesson();
                        lesson.setLessonName(lessonName1);

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

    private class ListSubjectsTask extends AsyncTask<Object, Object, Group> {
        protected Group doInBackground(Object... num) {



            String whereClause = "groupFaculty.faculty = '"+lesFaculty+"' AND groupNumber = "+numberOfGroup+" " +
                    "AND year = "+grYear;

            BackendlessDataQuery query = new BackendlessDataQuery();
            query.setWhereClause(whereClause);
            BackendlessCollection<Group> result = Backendless.Persistence.of(Group.class).find(query);
            Group group = result.getData().get(0);

            String whereClauseSubject = "fullName = '" + lessonNameString + "'";

            BackendlessDataQuery subjectQuery = new BackendlessDataQuery();
            subjectQuery.setWhereClause(whereClauseSubject);

            BackendlessCollection<Subject> subjects = Backendless.Persistence.of(Subject.class).find(subjectQuery);
            Subject subject = subjects.getData().get(0);

            String whereClauseAddress = "address = '"+lessonAddressString+"'";

            BackendlessDataQuery addressQuery = new BackendlessDataQuery();
            addressQuery.setWhereClause(whereClauseAddress);

            BackendlessCollection<Address> addresses = Backendless.Persistence.of(Address.class).find(addressQuery);
            Address address = addresses.getData().get(0);

            Lesson checkedLesson = Helper.check(group, Integer.valueOf(lesNumber), Converter.convertDayToInteger(lesDay),
                              Integer.valueOf(lesOrder), odd);

            if (checkedLesson == null){

                addLesson(group, subject, address, Integer.valueOf(lesNumber),Converter.convertDayToInteger(lesDay),
                        Integer.valueOf(lesOrder), Integer.valueOf(grYear), lecture, odd);

            }

            Lesson lesson = new Lesson();
            lesson.setLessonName(subject);
            lesson.setLessonAddress(address);
            lesson.setNumber(Integer.valueOf(lesNumber));
            lesson.setDayOfWeek(Converter.convertDayToInteger(lesDay));
            lesson.setOrder(Integer.valueOf(lesOrder));
            lesson.setYear(Integer.valueOf(grYear));
            lesson.setIsLecture(lecture);
            lesson.setIsOdd(odd);

            Backendless.Persistence.save(group);

            return group;
        }

        protected void onProgressUpdate(Object... progress) {

        }

        protected void onPostExecute(Group result) {

            if(result != null){
                Toast.makeText(getApplicationContext(), "This lesson have in schedule", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "This lesson not found in schedule", Toast.LENGTH_LONG).show();
            }

        }


    }

    private void addLesson (Group group, Subject subject, Address address,
                            int lesNumber, int lesDay, int lesOrder,
                            int groupYear, boolean isLecture, boolean isOdd){


        Lesson lesson = new Lesson();
        lesson.setLessonName(subject);
        lesson.setLessonAddress(address);
        lesson.setNumber(lesNumber);
        lesson.setDayOfWeek(lesDay);
        lesson.setOrder(lesOrder);
        lesson.setYear(groupYear);
        lesson.setIsLecture(isLecture);
        lesson.setIsOdd(isOdd);

        group.getGroupLesson().add(lesson);
        Backendless.Persistence.save(group);

    }

}
