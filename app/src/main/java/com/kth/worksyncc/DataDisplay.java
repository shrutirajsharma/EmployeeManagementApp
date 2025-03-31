package com.kth.worksyncc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class DataDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_page);

        // Getting data from Intent
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        // Finding TextViews by ID and setting the values
        TextView empName = findViewById(R.id.empName);
        TextView empId = findViewById(R.id.empId);
        TextView empEmail = findViewById(R.id.empEmail);
        TextView empContact = findViewById(R.id.empContact);
        TextView empAddress = findViewById(R.id.empAddress);

        empName.setText(name);
        empId.setText(id);
        empEmail.setText(email);
        empContact.setText(phone);
        empAddress.setText(address);


        MaterialButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
