package com.zeljkostankovic.safbox_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zeljkostankovic.safbox_app.R;

public class NewTimeChallengeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_time_challenge, container, false);

        Button cancel = view.findViewById(R.id.btnAbbrechenNewTime);



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_newTimeChallengeFragment_to_chooseChallengeTypFragment);
            }
        });


        return view;

    }


}