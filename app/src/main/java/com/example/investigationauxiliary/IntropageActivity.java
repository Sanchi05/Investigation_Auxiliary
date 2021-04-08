package com.example.investigationauxiliary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IntropageActivity extends AppCompatActivity {

    Button known, unknown,admin;
    //ImageView img_vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intropage);
        known = (Button) findViewById(R.id.known);
        unknown = (Button) findViewById(R.id.unknown);


        known.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntropageActivity.this, Register_Activity.class));
            }
        });
        unknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntropageActivity.this, Home_Activity.class));
            }
        });




    }
}
