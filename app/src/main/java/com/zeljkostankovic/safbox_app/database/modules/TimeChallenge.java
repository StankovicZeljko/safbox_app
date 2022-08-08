package com.zeljkostankovic.safbox_app.database.modules;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "time_challenge_table")
public class TimeChallenge {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int days;

    public int hours;

    public int minutes;

    public TimeChallenge() {
    }

    public TimeChallenge(int days, int hours, int minutes) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }


}
