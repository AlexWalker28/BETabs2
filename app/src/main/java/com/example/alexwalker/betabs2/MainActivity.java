package com.example.alexwalker.betabs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.backendless.Backendless;

public class MainActivity extends AppCompatActivity {

    Button changeLayout;
    AutoCompleteTextView lessonFaculty;
    AutoCompleteTextView lessonCourse;
    AutoCompleteTextView lessonGroup;
    AutoCompleteTextView lessonName;
    AutoCompleteTextView lessonNumber;
    AutoCompleteTextView lessonAddress;
    AutoCompleteTextView weekDay;
    AutoCompleteTextView lessonOrder;

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


        ArrayAdapter<String> facultyAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesFaculty);
        ArrayAdapter<String> courseAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesCourse);
        ArrayAdapter<String> groupAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesGroup);
        ArrayAdapter<String> nameAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesName);
        ArrayAdapter<String> numberAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesNumber);
        ArrayAdapter<String> addressAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesAddress);
        ArrayAdapter<String> dayAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, wDay);
        ArrayAdapter<String> orderAdapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, lesOrder);


        lessonName.setAdapter(nameAdapter);
        lessonNumber.setAdapter(numberAdapter);
        lessonAddress.setAdapter(addressAdapter);
        weekDay.setAdapter(dayAdapter);
        lessonOrder.setAdapter(orderAdapter);
    }

    private static final String[] lesFaculty = new String[]{

    };
    private static final String[] lesCourse = new String[]{

    };
    private static final String[] lesGroup = new String[]{

    };
    private static final String[] lesName = new String[]{

    };
    private static final String[] lesNumber = new String[]{

    };
    private static final String[] lesAddress = new String[]{

    };
    private static final String[] wDay = new String[]{

    };
    private static final String[] lesOrder = new String[]{

    };


    private void initVars() {

        lessonFaculty = (AutoCompleteTextView) findViewById(R.id.lessonFaculty1);
        lessonCourse = (AutoCompleteTextView) findViewById(R.id.lessonCourse1);
        lessonGroup = (AutoCompleteTextView) findViewById(R.id.lessonGroup1);
        lessonName = (AutoCompleteTextView)findViewById(R.id.lessonName1);
        lessonNumber = (AutoCompleteTextView) findViewById(R.id.lessonNumber1);
        lessonAddress = (AutoCompleteTextView) findViewById(R.id.lessonAddress1);
        weekDay = (AutoCompleteTextView)findViewById(R.id.weekDay1);
        lessonOrder = (AutoCompleteTextView)findViewById(R.id.lessonOrder1);

        changeLayout = (Button) findViewById(R.id.change);
    }
}
