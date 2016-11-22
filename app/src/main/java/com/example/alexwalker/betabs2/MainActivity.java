package com.example.alexwalker.betabs2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;

public class MainActivity extends AppCompatActivity {

    private Button changeLayout;
    private Button addLessonButton;
    private Button clearButton;
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
    private Boolean odd;
    private Boolean lecture;
    private Spinner yearSpinner;
    private String yearText;
    private String facultyText;
    private Spinner facultySpinner;


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

        final ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.YearSpinner, R.layout.support_simple_spinner_dropdown_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> nameAdapter = ArrayAdapter.createFromResource(this, R.array.Subjects, R.layout.support_simple_spinner_dropdown_item);
        nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> addressAdapter = ArrayAdapter.createFromResource(this, R.array.Addresses, R.layout.support_simple_spinner_dropdown_item);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(this, R.array.Week, R.layout.support_simple_spinner_dropdown_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> facultyAdapter = ArrayAdapter.createFromResource(this, R.array.Faculty, android.R.layout.simple_spinner_item);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lessonName.setAdapter(nameAdapter);
        lessonName.setThreshold(1);
        lessonAddress.setAdapter(addressAdapter);
        lessonAddress.setThreshold(1);
        weekDay.setAdapter(dayAdapter);
        weekDay.setThreshold(1);
        yearSpinner.setAdapter(yearAdapter);
        yearAdapter.notifyDataSetChanged();
        facultySpinner.setAdapter(facultyAdapter);
        facultyAdapter.notifyDataSetChanged();


        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        yearText = "1";
                        break;
                    case 1:
                        yearText = "2";
                        break;
                    case 2:
                        yearText = "3";
                        break;
                    case 3:
                        yearText = "4";
                        break;
                    case 4:
                        yearText = "5";
                        break;
                    case 5:
                        yearText = "6";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //yearText = "1";
            }
        });
        facultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        facultyText = "Лечебное дело";
                        break;
                    case 1:
                        facultyText = "Педиатрия";
                        break;
                    case 2:
                        facultyText = "Фармация";
                        break;
                    case 3:
                        facultyText = "Стоматология";
                        break;
                    case 4:
                        facultyText = "МПД";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                        facultyText = "Лечебное дело";
            }
        });


        addLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numberOfGroup = groupNumber.getText().toString();
                lessonNameString = lessonName.getText().toString();
                lessonAddressString = lessonAddress.getText().toString();
                lesNumber = lessonNumber.getText().toString();
                lesDay   = weekDay.getText().toString();
                lesOrder = lessonOrder.getText().toString();
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
                    }
                }).start();


            }
        });


    }


    private void initVars() {

        facultySpinner = (Spinner) findViewById(R.id.facult2);
        groupNumber = (EditText) findViewById(R.id.lessonGroup1);
        yearSpinner = (Spinner) findViewById(R.id.year2);
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

            String whereClause = "groupFaculty.faculty = '" + facultyText + "' AND groupNumber = " + numberOfGroup + " " +
                    "AND year = " + yearText;

            BackendlessDataQuery query = new BackendlessDataQuery();
            query.setWhereClause(whereClause);
            BackendlessCollection<Group> result = Backendless.Persistence.of(Group.class).find(query);
            Group group = result.getData().get(0);

            String whereClauseSubject = "fullName = '" + lessonNameString + "'";

            BackendlessDataQuery subjectQuery = new BackendlessDataQuery();
            subjectQuery.setWhereClause(whereClauseSubject);

            BackendlessCollection<Subject> subjects = Backendless.Persistence.of(Subject.class).find(subjectQuery);
            Subject subject = subjects.getData().get(0);

            String whereClauseAddress = "address = '" + lessonAddressString + "'";

            BackendlessDataQuery addressQuery = new BackendlessDataQuery();
            addressQuery.setWhereClause(whereClauseAddress);

            BackendlessCollection<Address> addresses = Backendless.Persistence.of(Address.class).find(addressQuery);
            Address address = addresses.getData().get(0);

            Lesson lesson = Helper.check(group, Integer.valueOf(lesNumber), Helper.convertDayToInteger(lesDay),
                              Integer.valueOf(lesOrder), odd);

            if (lesson == null) {

                lesson = new Lesson();
                lesson.setNumber(Integer.valueOf(lesNumber));
                lesson.setDayOfWeek(Helper.convertDayToInteger(lesDay));
                lesson.setOrder(Integer.valueOf(lesOrder));
                lesson.setIsOdd(odd);
                group.getGroupLesson().add(lesson);

            }

            lesson.setLessonName(subject);
            lesson.setLessonAddress(address);
            lesson.setIsLecture(lecture);


            Backendless.Persistence.save(group);

            return group;
        }
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
