package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // create database instance
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "desh").allowMainThreadQueries().build();
        // get all data from database using Dao methode and save it in the list
        List<Desh> deshesList = appDatabase.deshDao().getAll();
        // get the RecyclerView by id and set the layout
        RecyclerView deshesListRecyclerView = findViewById(R.id.deshRecyclerView);
        deshesListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter
        deshesListRecyclerView.setAdapter(new DeshAdapter(deshesList));
        // on click listener to back to main activity
        Button homeFromMenu = findViewById(R.id.homeFromMenu);
        homeFromMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent homeFromMenu = new Intent(Menu.this, MainActivity.class);
                startActivity(homeFromMenu);
            }
        });

    }
}