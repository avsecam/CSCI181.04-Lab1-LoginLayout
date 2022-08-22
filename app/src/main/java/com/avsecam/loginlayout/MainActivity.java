package com.avsecam.loginlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d("TEST", "onCreate");

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        tryLogin();
      }
    });
  }

  private void tryLogin() {
    String username = usernameField.getText().toString();
    String password = passwordField.getText().toString();
    Intent loginIntent = new Intent(MainActivity.this, LandingActivity.class);
    loginIntent.putExtra("username", username);
    loginIntent.putExtra("rememberMe", rememberMeField.isChecked());

    Toast toast;
    if (password.equals(PASSWORD)) {
      toast = Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT);


    } else {
      toast = Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_LONG);
    }
    toast.show();
  }


}