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

import org.w3c.dom.Text;

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

        View rootview =inflater.inflate(R.layout.fragment_history, container, false);
        tvReason = container.findViewById(R.id.tvReason);
        tvMood = (TextView) rootview.findViewById(R.id.tvMood);


        Bundle data = ((MainActivity)getActivity()).getSavedData();
        String dataString = data.getString("data");
        if (dataString != null) {
           tvMood.setText(dataString);
        }
        else
            {
             tvMood.setText("nukk");
            }

        // Inflate the layout for this fragment
        return rootview;
    }





}
