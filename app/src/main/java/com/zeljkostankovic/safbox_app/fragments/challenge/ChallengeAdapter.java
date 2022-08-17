package com.zeljkostankovic.safbox_app.fragments.challenge;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeljkostankovic.safbox_app.R;
import com.zeljkostankovic.safbox_app.database.modules.TimeChallenge;

import java.util.Collections;
import java.util.List;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder>{

    private List<TimeChallenge> timeChallengeList = Collections.emptyList();

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView bezeichner;
        private final TextView minuten;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bezeichner = (TextView) itemView.findViewById(R.id.timeListBezeichnung);
            minuten = (TextView) itemView.findViewById(R.id.timeListMinutsValue);
        }

        public TextView getBezeichner() {
            return bezeichner;
        }

        public TextView getMinuten() {
            return minuten;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_time_challenge_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getBezeichner().setText(timeChallengeList.get(position).description.toString());
        holder.getMinuten().setText(String.valueOf(timeChallengeList.get(position).minutes));

    }

    @Override
    public int getItemCount() {
        return timeChallengeList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<TimeChallenge> challenges) {

        this.timeChallengeList = challenges;
        notifyDataSetChanged();
    }

}
