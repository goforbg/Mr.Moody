package com.androar.mr_moody;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {


    TextView tvReason, tvMood;


    public HistoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tvReason = container.findViewById(R.id.tvReason);
        tvMood = container.findViewById(R.id.tvMood);


        Bundle bundle = getArguments();
        String moodx = bundle.getString("mood","ss");
        tvMood.setText(moodx);
        
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }





}
