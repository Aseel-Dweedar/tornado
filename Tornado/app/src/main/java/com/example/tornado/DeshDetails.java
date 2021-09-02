package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeshDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desh_details);
        // get the intent to get the data that sent from menu activity
        Intent intent = getIntent();
        // get all the textView to render the data inside
        TextView dishName = findViewById(R.id.nameToSet);
        TextView price = findViewById(R.id.priceToSet);
        TextView ingredients = findViewById(R.id.ingredientsToSet);
        // set the data in the views
        dishName.setText(intent.getExtras().getString("dishName"));
        price.setText(intent.getExtras().getString("price"));
        ingredients.setText(intent.getExtras().getString("ingredients"));
        // on click listener to back to menu page
        Button backToMenu = findViewById(R.id.backToMenu);
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent backToMenu = new Intent(DeshDetails.this, Menu.class);
                startActivity(backToMenu);
            }
        });
    }
}