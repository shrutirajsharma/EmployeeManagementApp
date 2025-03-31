package com.kth.worksyncc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginCredential extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_credential);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Toast.makeText(LoginCredential.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginCredential.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LoginCredential.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
