package com.avsecam.loginlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    TextView welcomeText = findViewById(R.id.welcomeText);
    String welcomeTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Intent loginIntent = getIntent();
        String username = loginIntent.getStringExtra("username");
        boolean isRemembered = loginIntent.getBooleanExtra("rememberMe", false);

        welcomeTextValue = "Welcome " + username + "! ";
        if (isRemembered) {
            welcomeText.setText(welcomeTextValue + "You will be remembered.\n");
        }
    }
}