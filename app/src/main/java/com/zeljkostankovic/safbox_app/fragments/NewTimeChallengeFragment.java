package com.zeljkostankovic.safbox_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.zeljkostankovic.safbox_app.R;
import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;
import com.zeljkostankovic.safbox_app.database.viewModels.TimeChallengeViewModel;

import java.util.Objects;

public class NewTimeChallengeFragment extends Fragment {


    private TimeChallengeViewModel mTimeChallengeViewModel;

    TextInputLayout description;
    TextInputLayout days;
    TextInputLayout hours;
    TextInputLayout minuts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_time_challenge, container, false);

        mTimeChallengeViewModel = new ViewModelProvider(this).get(TimeChallengeViewModel.class);
        description = view.findViewById(R.id.textInputLayoutBezeichnungNewTime);
        days = view.findViewById(R.id.textInputLayoutTage);
        hours = view.findViewById(R.id.textInputLayoutStunden);
        minuts = view.findViewById(R.id.textInputLayoutMinuten);

        Button cancel = view.findViewById(R.id.btnAbbrechenNewTime);
        Button add = view.findViewById(R.id.btnSpeichernNewTime);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_newTimeChallengeFragment_to_chooseChallengeTypFragment);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDataToDatabase(view);
            }
        });

            Objects.requireNonNull(days.getEditText()).setText("0");
            Objects.requireNonNull(hours.getEditText()).setText("0");
            Objects.requireNonNull(minuts.getEditText()).setText("0");


        return view;

    }

    private void insertDataToDatabase(View view) {

       try {
           String mDescription = Objects.requireNonNull(description.getEditText()).getText().toString();
           String mDays = Objects.requireNonNull(days.getEditText()).getText().toString();
           String mHours = Objects.requireNonNull(hours.getEditText()).getText().toString();
           String mMinutes = Objects.requireNonNull(minuts.getEditText()).getText().toString();

           if(validateInput(mDescription, mDays, mHours, mMinutes)) {
               TimeChallenge timeChallenge = new TimeChallenge(mDescription,mDays, mHours, mMinutes);
               mTimeChallengeViewModel.insert(timeChallenge);
               Toast.makeText(requireContext(), "Erfolgreich hinzugefügt", Toast.LENGTH_LONG).show();
               Navigation.findNavController(view).navigate(R.id.action_newTimeChallengeFragment_to_challengeFragment);

           } else {
               Toast.makeText(requireContext(), "Bitte füllen Sie das Formular aus", Toast.LENGTH_LONG).show();
           }

       } catch (Exception e) {

           Toast.makeText(requireContext(), "Bitte füllen Sie das Formular aus", Toast.LENGTH_LONG).show();
       }
    }

    private boolean validateInput(String desc, String day, String hour, String minut) {

        boolean value = false;

        if(!desc.isEmpty()) {

            if(!day.isEmpty() || !hour.isEmpty() || !minut.isEmpty()) {
                value = true;
            }

        }

        return value;
    }


}