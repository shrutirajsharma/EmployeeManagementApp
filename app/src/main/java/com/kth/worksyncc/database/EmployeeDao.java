package com.kth.worksyncc.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    void insert(EmployeeModel user);

    @Query("SELECT * FROM shadowproject")
    List<EmployeeModel> getAllUsers();

}
