package com.example.alexwalker.betabs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText faculty;
    EditText year;
    EditText group;
    Button button;
    Button changeLayout;
    String facultyText;
    String yearText;
    String groupText;
    ListView listView;
    Lesson lesson;
    String lessonName;
    String week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appVersion = "v1";
        Backendless.initApp(this, "ECD9BE7E-78DD-4F01-FF4E-EE88E8026F00", "9B5BC839-0646-3D7B-FF78-5662E53A0200", appVersion);

        faculty = (EditText) findViewById(R.id.faculty2);
        year = (EditText) findViewById(R.id.year2);
        group = (EditText) findViewById(R.id.group2);
        listView = (ListView) findViewById(R.id.listViewMain);
        changeLayout = (Button) findViewById(R.id.change);

        faculty.setText("Лечебное дело");
        year.setText("4");
        group.setText("27");

        facultyText = faculty.getText().toString();
        yearText = year.getText().toString();
        groupText = group.getText().toString();


        button = (Button) findViewById(R.id.button);


        changeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String whereClause = "groupFaculty.faculty = '" + faculty.getText().toString() + "' AND groupYear.year = "
                        + year.getText().toString() + " AND groupNumber = " + group.getText().toString();
                BackendlessDataQuery dataQuery = new BackendlessDataQuery();
                dataQuery.setWhereClause(whereClause);

                Backendless.Persistence.of(Group.class).find(dataQuery,
                        new AsyncCallback<BackendlessCollection<Group>>() {
                            @Override
                            public void handleResponse(BackendlessCollection<Group> foundGroups) {
                                Group foundGroup = foundGroups.getData().get(0);
                                List<Lesson> lessons = foundGroup.getGroupLesson();
                                Collections.sort(lessons, new LessonComparator());

                                LessonListAdapter mAdapter;
                                mAdapter = new LessonListAdapter(MainActivity.this);
                                mAdapter.addSectionHeaderItem("Понедельник");
                                //week = Converter.convertDay(lesson.getWeek().getDayOfTheWeek());
                                int count = lessons.size();
                                for (int i = 1; i < count; i++) {
                                    mAdapter.addItem(lessons.get(i).getLessonName().getFullName());
                                    if (i % 4 == 0) {
                                        mAdapter.addSectionHeaderItem(Converter.convertDay(lessons.get(i+1).getWeek().getDayOfTheWeek()));
                                    }
                                }
                                listView.setAdapter(mAdapter);


                        }

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });






                /*String whereClause = "groupFaculty.faculty = '" + faculty.getText().toString() + "' AND groupYear.year = "
                        + year.getText().toString() + " AND groupNumber = " + group.getText().toString();
                BackendlessDataQuery dataQuery = new BackendlessDataQuery();
                dataQuery.setWhereClause(whereClause);

                Backendless.Persistence.of(Group.class).find(dataQuery,
                        new AsyncCallback<BackendlessCollection<Group>>() {
                            @Override
                            public void handleResponse(BackendlessCollection<Group> foundGroups) {
                                Group foundGroup = foundGroups.getData().get(0);
                                *//*textView.setText(foundGroup.getGroupNumber().toString());*//*
                                List<Lesson> lessons = foundGroup.getGroupLesson();
                                *//*for (Lesson lesson : lessons) {
                                    textView.append("\n" + lesson.getLessonName().getFullName()
                                            + " " + lesson.getLessonNumber().getNumber());

                                }*//*
                                Collections.sort(lessons, new LessonComparator());
                                listView.setAdapter(new LessonsListAdapter(MainActivity.this, lessons));

                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {

                            }
                        });*/






                /*Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
*/
                /*Backendless.Persistence.of(Group.class).find(new AsyncCallback<BackendlessCollection<Group>>() {
                    @Override
                    public void handleResponse(BackendlessCollection<Group> groupBackendlessCollection) {
                        Group groupData = null;
                        int size = groupBackendlessCollection.getData().size();
                        for (int i = 0; i < size; i++) {
                            groupData = groupBackendlessCollection.getData().get(i);
                            String lessonNumber = groupData.getGroupNumber().toString();
                            textView.append(lessonNumber + "\n");

                        }


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
