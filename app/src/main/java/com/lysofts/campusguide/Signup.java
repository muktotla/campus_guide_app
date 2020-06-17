package com.lysofts.campusguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {


    private EditText emailTV, passwordTV,password2TV;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        initializeUI();
    }

    public void SignUp(View view) {
        String email, password,password2;
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();
        password2 = password2TV.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }
        if(!password.equals(password2)){
            Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_LONG).show();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(Signup.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later\n"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            Log.d("Errors: ",task.getException().getMessage());
                        }
                    }
                });
    }

    public void LoginView(View view) {
        startActivity(new Intent(Signup.this, Login.class));
        finish();
    }



    private void initializeUI() {
        emailTV = findViewById(R.id.txt_email);
        passwordTV = findViewById(R.id.txt_pass);
        password2TV = findViewById(R.id.txt_pass2);
        progressBar = findViewById(R.id.progressBar);
    }
}
