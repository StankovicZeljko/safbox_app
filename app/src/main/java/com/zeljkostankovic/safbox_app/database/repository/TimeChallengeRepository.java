package com.zeljkostankovic.safbox_app.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.zeljkostankovic.safbox_app.database.SafeBoxDatabase;
import com.zeljkostankovic.safbox_app.database.dao.TimeChallengeDao;
import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;

import java.util.List;

public class TimeChallengeRepository {

    private TimeChallengeDao mTimeChallengeDao;
    private LiveData<List<TimeChallenge>> mAllTimeChallenge;

    public TimeChallengeRepository(Application application) {

        SafeBoxDatabase db = SafeBoxDatabase.getDatabase(application);
        mTimeChallengeDao = db.timeChallangeDao();
        mAllTimeChallenge = mTimeChallengeDao.getAll();

    }

    public LiveData<List<TimeChallenge>> getmAllTimeChallenge() {
        return mAllTimeChallenge;
    }


    public void insert(TimeChallenge timeChallenge) {
        SafeBoxDatabase.databaseWriteExecutor.execute( () -> {
            mTimeChallengeDao.insert(timeChallenge);
        });
    }

}
