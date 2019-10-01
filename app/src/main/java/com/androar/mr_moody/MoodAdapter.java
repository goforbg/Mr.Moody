package com.androar.mr_moody;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoodAdapter extends RecyclerView.Adapter <MoodAdapter.ViewHolder> {

    public ArrayList<Mood> moods;

    public MoodAdapter(Context context, ArrayList<Mood> list)
    {
     moods = list;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        ImageView ivHistoryMood;
        TextView tvHistoryMood;
        TextView tvHistoryReason;
        TextView tvHistoryTime;

        public ViewHolder (@NonNull View itemView){
                super(itemView);

                ivHistoryMood = itemView.findViewById(R.id.ivHistoryMood);
                tvHistoryMood = itemView.findViewById(R.id.tvHistoryMood);
                tvHistoryReason = itemView.findViewById(R.id.tvHistoryReason);
                tvHistoryTime = itemView.findViewById(R.id.tvHistoryTime);
        }
    }
    @NonNull
    @Override
    public MoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(moods.get(position));
        holder.tvHistoryMood.setText(moods.get(position).getMood());
        holder.tvHistoryReason.setText(moods.get(position).getReason());
        holder.tvHistoryTime.setText(moods.get(position).getDate());

       if (moods.get(position).getMood().equals("happy")) {
            holder.ivHistoryMood.setImageResource(R.drawable.ic_happy);
        }

        if (moods.get(position).getMood().equals("sad")) {
            holder.ivHistoryMood.setImageResource(R.drawable.ic_sad);
        }

        if (moods.get(position).getMood().equals("smile")) {
            holder.ivHistoryMood.setImageResource(R.drawable.ic_smile);
        }

        if (moods.get(position).getMood().equals("fucked")) {
            holder.ivHistoryMood.setImageResource(R.drawable.ic_fucked);
        }


    }

    @Override
    public int getItemCount() {
        return moods.size();
    }
}
