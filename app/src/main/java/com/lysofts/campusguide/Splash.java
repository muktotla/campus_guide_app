package com.lysofts.campusguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView username;
    Handler mHandler;
    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.text_username);

        splash();
    }

    private void splash(){
        mHandler=new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mAuth.getCurrentUser() != null){
                    Intent intent=new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent=new Intent(Splash.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        },5000);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user){
        if (user != null){
            username.setText("" +user.getEmail());
        }
    }
}
