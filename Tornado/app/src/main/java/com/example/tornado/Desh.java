package com.example.tornado;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Desh {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "dish_name")
    public String dishName;
    @ColumnInfo(name = "dish_price")
    public String price;
    @ColumnInfo(name = "dish_ingredients")
    public String ingredients;

    public Desh(String dishName, String price, String ingredients) {
        this.dishName = dishName;
        this.price = price;
        this.ingredients = ingredients;
    }
}
