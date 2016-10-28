package com.example.alexwalker.betabs2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText faculty;
    EditText year;
    EditText group;
    Button button;

    String facultyText;
    String yearText;
    String groupText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String appVersion = "v1";
        Backendless.initApp(this, "ECD9BE7E-78DD-4F01-FF4E-EE88E8026F00", "9B5BC839-0646-3D7B-FF78-5662E53A0200", appVersion);

        faculty = (EditText) findViewById(R.id.faculty);
        year = (EditText) findViewById(R.id.year);
        group = (EditText) findViewById(R.id.group);

        faculty.setText("Лечебное дело");
        year.setText("4");
        group.setText("27");

        facultyText = faculty.getText().toString();
        yearText = year.getText().toString();
        groupText = group.getText().toString();




        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);


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
                                textView.setText(foundGroups.getData().get(0).getObjectId().toString());
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                textView.setText(fault.toString());
                            }
                        });



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
                            String groupNumber = groupData.getGroupNumber().toString();
                            textView.append(groupNumber + "\n");

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
