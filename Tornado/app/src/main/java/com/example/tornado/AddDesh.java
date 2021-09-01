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

        Button submitButton = findViewById(R.id.submit);
        EditText dishName = findViewById(R.id.enterDeshName);
        EditText price = findViewById(R.id.enterDeshPrice);
        EditText ingredients = findViewById(R.id.enterIngredients);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Desh newDesh = new Desh(dishName.getText().toString(), price.getText().toString(), ingredients.getText().toString());
                appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "desh").allowMainThreadQueries().build();
                appDatabase.deshDao().insertAll(newDesh);
                Toast.makeText(getApplicationContext(), "submitted!", Toast.LENGTH_SHORT).show();
                Intent goToHome = new Intent(AddDesh.this, MainActivity.class);
                startActivity(goToHome);
            }
        });
    }
}