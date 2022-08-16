package com.zeljkostankovic.safbox_app.fragments.challenge;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.zeljkostankovic.safbox_app.R;


public class ChooseChallengeTypFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_choose_challenge_typ, container, false);

        ImageButton imageButton = view.findViewById(R.id.backBTN);

        CardView cardViewTime = view.findViewById(R.id.cardViewTime);

        CardView cardViewCode = view.findViewById(R.id.cardViewCode);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_chooseChallengeTypFragment_to_challengeFragment);

            }
        });


        cardViewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_chooseChallengeTypFragment_to_newTimeChallengeFragment);
            }
        });


        cardViewCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_chooseChallengeTypFragment_to_newCodeChallengeFragment);
            }
        });

        return view;

    }

}
