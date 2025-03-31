package com.kth.worksyncc.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EmployeeModel.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract EmployeeDao empDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE ==null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "EmployeeModel")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
