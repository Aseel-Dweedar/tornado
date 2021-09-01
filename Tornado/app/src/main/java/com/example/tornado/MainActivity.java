package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on click listener on the menu button to direct to menu activity
        Button goToMenuButton = findViewById(R.id.menuButton);
        goToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent goToMenu = new Intent(MainActivity.this, Menu.class);
                startActivity(goToMenu);
            }
        });
        // on click listener on the add dish button to direct to AddDesh activity
        Button addDeshButton = findViewById(R.id.addDeshButton);
        addDeshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent addDeshButton = new Intent(MainActivity.this, AddDesh.class);
                startActivity(addDeshButton);
            }
        });

    }
}