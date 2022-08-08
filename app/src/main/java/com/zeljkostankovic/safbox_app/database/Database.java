package com.zeljkostankovic.safbox_app.database;

import androidx.room.RoomDatabase;

import com.zeljkostankovic.safbox_app.database.dao.TimeChallangeDao;
import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;

@androidx.room.Database(entities = {TimeChallenge.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract TimeChallangeDao timeChallangeDao();

}
