package com.example.investigationauxiliary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Login_Activity extends AppCompatActivity {

    private EditText e_email, e_password;
    private Button btnlogin;
    FirebaseAuth e_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        e_email = (EditText) findViewById(R.id.email_entered);
        e_password = (EditText) findViewById(R.id.password_entered);
        btnlogin = (Button) findViewById(R.id.login);

        e_auth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_user();

            }
        });

    }

    private void login_user() {
        String email = e_email.getText().toString();
        String password = e_password.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                e_auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Login_Activity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login_Activity.this, Home_Activity.class));
                                finish();
                            }
                        }) .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login_Activity.this,"Please add a correct details!",Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                e_password.setError("Please enter the Password!");
            }

        } else if(email.isEmpty()){
            e_email.setError("Please enter the Email!");
        }
        else{
            e_email.setError("Please enter a valid email address!");
        }
    }


}