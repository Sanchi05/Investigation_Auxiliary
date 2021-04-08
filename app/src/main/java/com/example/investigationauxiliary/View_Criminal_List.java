package com.example.investigationauxiliary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class View_Criminal_List extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__criminal__list);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(View_Criminal_List.this,Criminal_Report.class));
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Upload_Data_2[] my_data_1 = new Upload_Data_2[]{
                new Upload_Data_2("Name:  Robert William Fisher \nAge:59 \nGender : Male\nHeight: 6'0''\nWeight: 86kgs\nEye Colour: Blue", R.drawable.criminal1),
                new Upload_Data_2("Name: Jason Derek Brown \nAge: 51 \nGender: Male \nHeight: 5'10'' \nWeight: 82kgs \nEye Colour: Green", R.drawable.criminal2),
                new Upload_Data_2("(A recent picture is not available)\nName: Daniel Hiers  \nAge: 49 \nGender: Male \nHeight: 6'3'' \nWeight: 95kgs  \nEye Colour: Blue ", R.drawable.criminal3),
                new Upload_Data_2("Name: Jose Corona \nAge: 61  \nGender: Male \nHeight: 5'5''  \nWeight: 77kgs  \nEye Colour: Brown ",R.drawable.criminal4)

        };
        MyAdapter1 myAdapter1 = new MyAdapter1(my_data_1, View_Criminal_List.this);
        recyclerView.setAdapter(myAdapter1);

    }
}

