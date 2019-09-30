package com.androar.mr_moody;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    String mood, reason, time;
    ArrayList<Mood> moods;

    public HistoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview =inflater.inflate(R.layout.fragment_history, container, false);


        Bundle data = ((MainActivity)getActivity()).getSavedData();
        Mood moodx =  (Mood)data.getSerializable("moods");


        recyclerView = rootview.findViewById(R.id.recyclerView);
        //recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        moods = new ArrayList<Mood>();
        moods.add(new Mood(moodx.getMood(), moodx.getReason(), moodx.getDate()));

        myAdapter = new MoodAdapter(getActivity(), moods);
        recyclerView.setAdapter(myAdapter);


        return rootview;
    }





}
