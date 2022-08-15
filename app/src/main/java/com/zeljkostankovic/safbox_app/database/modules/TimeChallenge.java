package com.zeljkostankovic.safbox_app.database.modules;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "time_challenge_table")
public class TimeChallenge {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String description;

    public int days;

    public int hours;

    public int minutes;

    public TimeChallenge() {
    }

    public TimeChallenge(String description, int days, int hours, int minutes) {
        this.description = description;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }


    public TimeChallenge(String description, String days, String hours, String minutes) {
        this.description = description;
        this.days = Integer.parseInt(days);
        this.hours = Integer.parseInt(hours);
        this.minutes = Integer.parseInt(minutes);
    }
}
