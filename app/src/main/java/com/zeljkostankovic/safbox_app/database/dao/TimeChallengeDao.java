package com.zeljkostankovic.safbox_app.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;

import java.util.List;

@Dao
public interface TimeChallengeDao {

    String table = "time_challenge_table";

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(TimeChallenge timeChallenge);

    @Query("SELECT * FROM " + table)
    LiveData<List<TimeChallenge>> getAll();

    @Query("SELECT * FROM " + table + " WHERE id LIKE :id LIMIT 1")
    TimeChallenge findById(int id);

    @Delete
    public void delete(TimeChallenge timeChallenge);

}
