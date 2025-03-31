package com.kth.worksyncc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kth.worksyncc.database.AppDatabase;
import com.kth.worksyncc.database.EmployeeModel;

import java.util.concurrent.Executors;

public class EmployeeDetailActivity extends AppCompatActivity {

    private AppDatabase db;

    private EditText nameEditText, emailEditText, mobileEditText, addressEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);





        db= AppDatabase.getInstance(this);

        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        mobileEditText = findViewById(R.id.mobile);
        addressEditText = findViewById(R.id.address);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String mobile = mobileEditText.getText().toString().trim();
            String address = addressEditText.getText().toString().trim();


                    if (name.isEmpty()) {
                        Toast.makeText(EmployeeDetailActivity.this, "Name is required", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(EmployeeDetailActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (mobile.isEmpty() || !mobile.matches("\\d{10}")) {
                        Toast.makeText(EmployeeDetailActivity.this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (address.isEmpty()) {
                        Toast.makeText(EmployeeDetailActivity.this, "Address is required", Toast.LENGTH_SHORT).show();
                        return;
                    }


                EmployeeModel employeeModel = new EmployeeModel(name, email, mobile, address);
                Executors.newSingleThreadScheduledExecutor().execute(() -> {
                    db.empDao().insert(employeeModel);
                });


                Toast.makeText(EmployeeDetailActivity.this, "Employee Record Saved Successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EmployeeDetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
        });
    }
}
