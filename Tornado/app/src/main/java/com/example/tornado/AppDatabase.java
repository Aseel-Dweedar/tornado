package com.example.tornado;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Desh.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DeshDao deshDao();
}
