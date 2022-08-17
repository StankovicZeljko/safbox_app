package com.zeljkostankovic.safbox_app.fragments.challenge;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zeljkostankovic.safbox_app.R;
import com.zeljkostankovic.safbox_app.database.viewModels.TimeChallengeViewModel;

public class ChallengeFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected ChallengeAdapter mChallengeAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);

        TimeChallengeViewModel mTimeChallengeViewModel = new ViewModelProvider(this).get(TimeChallengeViewModel.class);

        mChallengeAdapter = new ChallengeAdapter();
        mRecyclerView = view.findViewById(R.id.challengeRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mChallengeAdapter);

        mTimeChallengeViewModel.getAll().observe(getViewLifecycleOwner(), challange -> {
            mChallengeAdapter.setData(challange);
        });

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButtonChallenge);

        floatingActionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Navigation.findNavController(view).navigate(R.id.action_challengeFragment_to_chooseChallengeTypFragment);
                    }
                }
        );

        return view;
    }
}