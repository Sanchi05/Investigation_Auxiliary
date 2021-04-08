package com.example.investigationauxiliary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {

    private EditText uemail, upass, urepass;
    private Button btnregister;
    private TextView login;

    private FirebaseAuth uauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);

        uemail = (EditText)findViewById(R.id.email);
        upass = (EditText)findViewById(R.id.password);
        urepass = (EditText)findViewById(R.id.retype);
        btnregister = (Button)findViewById(R.id.register);
        login = (TextView)findViewById(R.id.register_login);

        uauth = FirebaseAuth.getInstance();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_user();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_Activity.this, Login_Activity.class));
                finish();
            }
        });

    }
    private void register_user(){
        String email = uemail.getText().toString();
        String password = upass.getText().toString();
        String repassword = urepass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            if (!password.isEmpty())
            {
                if (password.equals(repassword))
                {
                    uauth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(Register_Activity.this,"Successfully registered!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Register_Activity.this, Login_Activity.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Register_Activity.this,"Registration Error!",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    upass.setError("Passwords do not match.Try again!");
                }
            }
            else{
                upass.setError("Password field is empty!");
            }
        }
        else if (email.isEmpty()){
            uemail.setError("Email field is empty!");
        }
        else {
            uemail.setError("Enter a valid email.Try again!");
        }
    }
}