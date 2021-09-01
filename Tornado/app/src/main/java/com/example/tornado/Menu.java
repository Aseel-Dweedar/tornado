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

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "desh").allowMainThreadQueries().build();
        List<Desh> deshesList = appDatabase.deshDao().getAll();
        RecyclerView deshesListRecyclerView = findViewById(R.id.deshRecyclerView);
        deshesListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        deshesListRecyclerView.setAdapter(new DeshAdapter(deshesList));

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