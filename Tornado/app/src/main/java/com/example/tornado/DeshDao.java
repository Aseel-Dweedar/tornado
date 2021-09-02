package com.example.tornado;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
// DeshDao and the methods the app uses to interact with database
@Dao
public interface DeshDao {

    @Query("SELECT * FROM desh")
    List<Desh> getAll();

    @Insert
    void insertAll(Desh... deshes);

    @Delete
    void delete(Desh desh);

}
