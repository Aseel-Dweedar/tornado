package com.example.tornado;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DeshDao {

    @Query("SELECT * FROM desh")
    List<Desh> getAll();

    @Insert
    void insertAll(Desh... deshes);

    @Delete
    void delete(Desh desh);

}
