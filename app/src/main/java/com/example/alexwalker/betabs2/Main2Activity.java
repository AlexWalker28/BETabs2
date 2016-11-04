package com.example.alexwalker.betabs2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    Spinner faculty;
    Spinner year;
    Spinner group;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        faculty = (Spinner) findViewById(R.id.faculty2);
        year = (Spinner) findViewById(R.id.year2);
        group = (Spinner) findViewById(R.id.group2);
        button2 = (Button) findViewById(R.id.button2);

        String[] data = {"Лечебное дело", "Педиатрия",  "Фармация", "Стоматология", "МПД"};



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



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
