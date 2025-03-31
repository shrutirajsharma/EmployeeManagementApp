package com.kth.worksyncc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kth.worksyncc.database.AppDatabase;
import com.kth.worksyncc.database.EmployeeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ItemAdapter adapter;
    private List<EmployeeModel> itemList = new ArrayList<>();
    private TextView textView;
    private ImageView addButton;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ItemAdapter(itemList, position -> {
            String id= String.valueOf(itemList.get(position).getId());
            String name= itemList.get(position).getName();
            String email= itemList.get(position).getEmail();
            String phone= itemList.get(position).getPhone();
            String address= itemList.get(position).getAddress();

            Intent intent= new Intent(this, DataDisplay.class);  //
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            startActivity(intent);

        });
        recyclerView.setAdapter(adapter);


        db= AppDatabase.getInstance(this);
        textView = findViewById(R.id.textView);
        addButton = findViewById(R.id.addButton);
        textView.setText("No Data Entered");
        addButton.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, EmployeeDetailActivity.class);
            startActivity(intent);
        });
        FetchUsers();
    }

    private void FetchUsers() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<EmployeeModel> users = db.empDao().getAllUsers();
            itemList.addAll(users);
            adapter.notifyDataSetChanged();

        });
    }}














