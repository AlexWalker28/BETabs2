package com.example.alexwalker.betabs2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    Spinner facultySpinner;
    Spinner yearSpinner;
    EditText group;
    Button button2;
    String facultyText;
    String yearText;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String appVersion = "v1";
        Backendless.initApp(this, "ECD9BE7E-78DD-4F01-FF4E-EE88E8026F00", "9B5BC839-0646-3D7B-FF78-5662E53A0200", appVersion);

        facultySpinner = (Spinner) findViewById(R.id.facult2);
        yearSpinner = (Spinner) findViewById(R.id.year2);
        group = (EditText) findViewById(R.id.group2);
        button2 = (Button) findViewById(R.id.button2);
        listView = (ListView) findViewById(R.id.listView2);
        error = (TextView) findViewById(R.id.textView);

        final ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(this, R.array.YearSpinner, R.layout.support_simple_spinner_dropdown_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter<CharSequence> facultyAdapter = ArrayAdapter.createFromResource(this, R.array.Faculty, android.R.layout.simple_spinner_item);
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        facultySpinner.setAdapter(facultyAdapter);
        yearSpinner.setAdapter(yearAdapter);
        facultyAdapter.notifyDataSetChanged();
        yearAdapter.notifyDataSetChanged();

        facultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
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


        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
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




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String whereClause = "groupFaculty.faculty = '" + facultyText + "' AND groupYear.year = "
                        + yearText + " AND groupNumber = " + group.getText().toString();
                BackendlessDataQuery dataQuery = new BackendlessDataQuery();
                dataQuery.setWhereClause(whereClause);

                Backendless.Persistence.of(Group.class).find(dataQuery,
                        new AsyncCallback<BackendlessCollection<Group>>() {
                            @Override
                            public void handleResponse(BackendlessCollection<Group> foundGroups) {
                                Group foundGroup = foundGroups.getData().get(0);
                                List<Lesson> lessons = foundGroup.getGroupLesson();
                                Collections.sort(lessons, new LessonComparator());
                                listView.setAdapter(new LessonsListAdapter(Main2Activity.this, lessons));

                            }
                            @Override
                            public void handleFault(BackendlessFault fault) {
                                error.setText(fault.toString());
                            }
                        });




                /*Backendless.Persistence.of(Group.class).find(new AsyncCallback<BackendlessCollection<Group>>() {
                    @Override
                    public void handleResponse(BackendlessCollection<Group> groupBackendlessCollection) {

                        listView.setAdapter(new LessonsListAdapter(Main2Activity.this, groupBackendlessCollection));


                    }
                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {

                        Toast.makeText(getApplicationContext(), "Didn't work", Toast.LENGTH_SHORT).show();
                    }
                });
*/

                /*String whereClause =  "lessonNumber = 27"   ; //"groupFaculty LIKE '%" + facultyText + "%' AND groupYear LIKE '%" + yearText + "%' AND lessonNumber LIKE '%" + groupText + "%'";
                BackendlessDataQuery dataQuery = new BackendlessDataQuery();
                dataQuery.setWhereClause(whereClause);

                Backendless.Persistence.of(Group.class).find(dataQuery, new AsyncCallback<BackendlessCollection<Group>>() {
                    @Override
                    public void handleResponse(BackendlessCollection<Group> groupBackendlessCollection) {
                        listView.setAdapter(new LessonsListAdapter(Main2Activity.this, groupBackendlessCollection));

                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast.makeText(getApplicationContext(), "Didn't work", Toast.LENGTH_SHORT).show();

                    }
                });*/


            }
        });


    }
}
