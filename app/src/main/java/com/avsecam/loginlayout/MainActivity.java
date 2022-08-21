package com.avsecam.loginlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  final String PASSWORD = "1234";

  final EditText usernameField = (EditText) findViewById(R.id.usernameInput);
  final EditText passwordField = (EditText) findViewById(R.id.passwordInput);
  final CheckBox rememberMeField = (CheckBox) findViewById(R.id.rememberMeCheckbox);
  final Button loginButton = (Button) findViewById(R.id.loginButton);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Context ctx = this;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        if (password == PASSWORD) {
          Toast toast = Toast.makeText(ctx, "Logging in...", Toast.LENGTH_SHORT);
          toast.show();
        } else {
          Toast toast = Toast.makeText(ctx, "Invalid credentials.", Toast.LENGTH_LONG);
        }
      }
    });
  }



}