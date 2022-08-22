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

  private EditText usernameField;
  private EditText passwordField;
  private CheckBox rememberMeField;
  private Button loginButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    usernameField = findViewById(R.id.usernameInput);
    passwordField = findViewById(R.id.passwordInput);
    rememberMeField = findViewById(R.id.rememberMeCheckbox);
    loginButton = findViewById(R.id.loginButton);

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
    Intent loginIntent = new Intent(this, LandingActivity.class);
    loginIntent.putExtra("username", username);
    loginIntent.putExtra("rememberMe", rememberMeField.isChecked());

    Toast toast;
    if (password.equals(PASSWORD) && usernameField.getText().length() > 0) {
      toast = Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT);
      startActivity(loginIntent);
    } else {
      toast = Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_LONG);
    }
    toast.show();
  }


}