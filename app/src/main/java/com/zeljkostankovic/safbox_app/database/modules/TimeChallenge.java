package com.zeljkostankovic.safbox_app.database.modules;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "time_challenge_table")
public class TimeChallenge {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String description;

    public int minutes;

    public TimeChallenge() {
    }

    public TimeChallenge(String description, int minutes) {
        this.description = description;
        this.minutes = minutes;
    }


    public TimeChallenge(String description, String minutes) {
        this.description = description;
        this.minutes = Integer.parseInt(minutes);
    }
}
