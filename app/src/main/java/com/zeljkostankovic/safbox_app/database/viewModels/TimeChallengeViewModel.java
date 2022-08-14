package com.zeljkostankovic.safbox_app.database.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;
import com.zeljkostankovic.safbox_app.database.repository.TimeChallengeRepository;

import java.util.List;

public class TimeChallengeViewModel extends AndroidViewModel {

    private TimeChallengeRepository mTimeChallengeRepository;
    private final LiveData<List<TimeChallenge>> mAllTimeChallenges;

    public TimeChallengeViewModel(@NonNull Application application) {
        super(application);
        mTimeChallengeRepository = new TimeChallengeRepository(application);
        mAllTimeChallenges = mTimeChallengeRepository.getmAllTimeChallenge();
    }

    public LiveData<List<TimeChallenge>> getAll() {
        return mAllTimeChallenges;
    }

    public void insert(TimeChallenge timeChallenge) {
        mTimeChallengeRepository.insert(timeChallenge);
    }

}
