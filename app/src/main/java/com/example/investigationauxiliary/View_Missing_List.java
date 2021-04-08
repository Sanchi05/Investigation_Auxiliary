package com.example.investigationauxiliary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class View_Missing_List extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__missing__list);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_Missing_List.this,Missing_Report.class));
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Upload_Data_1[] my_data = new Upload_Data_1[]{
                new Upload_Data_1("(A recent picture is not available)\nName: Natalee Ann Holloway\nAge: 33 \nGender : Female\nHeight: 5'4''\nWeight: NA \nEye Colour: Blue",R.drawable.missinng1),
                new Upload_Data_1("Name: Morgan Nick \nAge: 32 \nGender : Female\nHeight: NA\nWeight: NA\nEye Colour: Blue",R.drawable.missing2),
                new Upload_Data_1("Name: Angela Hammond \nAge: 50 \nGender : Female\nHeight: 4'11'\nWeight: 54kgs\nEye Colour: Brown",R.drawable.missing3),
                new Upload_Data_1("(a recent picture is not available)\nName: Lena Chapin \nAge:59 \nGender : Female\nHeight: 5'8'' - 5'10'\nWeight: 59kgs\nEye Colour: Blue",R.drawable.missing4),
                new Upload_Data_1("Name: Amy Billig\nAge: 64 \nGender Female\nHeight: 5'5''\nWeight: 50kgs\nEye Colour: Brown",R.drawable.missinng5),

        };
        MyAdapter myAdapter = new MyAdapter(my_data,View_Missing_List.this);
        recyclerView.setAdapter(myAdapter);

    }
}
