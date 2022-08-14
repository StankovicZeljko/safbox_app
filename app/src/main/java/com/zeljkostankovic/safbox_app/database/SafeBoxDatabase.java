package com.zeljkostankovic.safbox_app.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.zeljkostankovic.safbox_app.database.dao.TimeChallengeDao;
import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {TimeChallenge.class}, version = 1)
public abstract class SafeBoxDatabase extends RoomDatabase {

    public abstract TimeChallengeDao timeChallangeDao();

    private static volatile SafeBoxDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static public ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static SafeBoxDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SafeBoxDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SafeBoxDatabase.class, "word_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
