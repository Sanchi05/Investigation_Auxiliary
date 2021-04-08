package com.example.investigationauxiliary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
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

public class Criminal_Report extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button btn_time_c, btn_submit_c;
    EditText time_view_c, loc_c, name_c;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference node = db.getReference().child("Criminals");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal__report);

        btn_time_c = (Button) findViewById(R.id.time_button_c);
        loc_c = (EditText) findViewById(R.id.location_c);
        time_view_c = (EditText) findViewById(R.id.time_c);
        btn_submit_c = (Button) findViewById(R.id.report_button_c);
        name_c = (EditText) findViewById(R.id.criminal_name);


        btn_time_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker1 = new Time_Picker_Fragment();
                timepicker1.show(getSupportFragmentManager(), "time picker");

            }
        });

        btn_submit_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_Data();
            }
        });



    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        time_view_c = findViewById(R.id.time_c);
        time_view_c.setText(hourOfDay + ":" + minute);
    }

    private void set_Data() {


        String t1 = loc_c.getText().toString();
        String t2 = time_view_c.getText().toString();
        String t3 = name_c.getText().toString();
        DataHolder1 d_h1 = new DataHolder1(t2, t1, t3);
        node.child(t2).setValue(d_h1);

        loc_c.setText("");
        time_view_c.setText("");
        name_c.setText("");
        Toast.makeText(Criminal_Report.this, "Thank you for helping!Your data has been stored.", Toast.LENGTH_SHORT).show();

    }
}