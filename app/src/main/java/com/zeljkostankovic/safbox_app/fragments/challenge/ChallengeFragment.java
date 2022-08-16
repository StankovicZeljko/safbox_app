package com.zeljkostankovic.safbox_app.fragments.challenge;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zeljkostankovic.safbox_app.R;

public class ChallengeFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge, container, false);

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