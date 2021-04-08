package com.example.investigationauxiliary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {

    private ImageView missing, criminal;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        criminal = findViewById(R.id.criminal_iv);
        missing  = findViewById(R.id.missing_iv);
        missing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this, View_Missing_List.class));
            }
        });

        criminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this, View_Criminal_List.class));
            }
        });


    }
}