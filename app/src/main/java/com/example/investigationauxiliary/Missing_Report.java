package com.example.investigationauxiliary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Missing_Report extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button btn_time, btn_submit;
    EditText time_view, loc, name_m;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("Missing");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing__report);

        btn_time = (Button) findViewById(R.id.time_button);
        loc = (EditText) findViewById(R.id.location);
        time_view = (EditText) findViewById(R.id.time);
        btn_submit = (Button) findViewById(R.id.report_button);
        name_m = (EditText) findViewById(R.id.missing_name);

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new Time_Picker_Fragment();
                timepicker.show(getSupportFragmentManager(), "time picker");

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_Data();
            }
        });



    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time_view = findViewById(R.id.time);
        time_view.setText(hourOfDay + ":" + minute);
    }

    private void set_Data() {

        String t1 = loc.getText().toString();
        String t2 = time_view.getText().toString();
        String t3 = name_m.getText().toString();
        DataHolder d_h = new DataHolder(t2, t1,t3);
        node.child(t2).setValue(d_h);

        loc.setText("");
        time_view.setText("");
        name_m.setText("");
        Toast.makeText(Missing_Report.this, "Thank you for helping!Your data has been stored.", Toast.LENGTH_SHORT).show();


    }
}