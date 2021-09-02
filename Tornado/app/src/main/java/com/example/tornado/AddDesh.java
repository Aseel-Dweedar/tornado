package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDesh extends AppCompatActivity {
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_desh);

        // get all edit text by Id to get there content and create dish instance
        // get the submit button by id
        Button submitButton = findViewById(R.id.submit);
        EditText dishName = findViewById(R.id.enterDeshName);
        EditText price = findViewById(R.id.enterDeshPrice);
        EditText ingredients = findViewById(R.id.enterIngredients);

        // add event listener to submit button to save data on database
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                // create dish instance from edit text content
                Desh newDesh = new Desh(dishName.getText().toString(), price.getText().toString(), ingredients.getText().toString());
                // create database instance
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "desh").allowMainThreadQueries().build();
                // get an instance of the DAO use the methods from it to save data in the database
                appDatabase.deshDao().insertAll(newDesh);
                // add a Toast to alert that data saved
                Toast.makeText(getApplicationContext(), "submitted!", Toast.LENGTH_SHORT).show();
                // create go home intent and move to home on click
                Intent goToHome = new Intent(AddDesh.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}