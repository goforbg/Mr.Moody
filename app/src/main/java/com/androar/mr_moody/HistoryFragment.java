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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    String smood, sreason, stime;
    ArrayList<Mood> moodslist;


    public HistoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview =inflater.inflate(R.layout.fragment_history, container, false);


        MoodsDB db = new MoodsDB(getActivity());
        db.open();
            smood = db.getDBMood();
            sreason = db.getDBReason();
            stime = db.getDBTime();
            Log.d("history received mood", smood);
            Log.d("history recevied reason", sreason);
            Log.d("history received time", stime);
        db.close();

        moodslist = new ArrayList<Mood>();
        moodslist.add(new Mood(smood,sreason,stime));



        myAdapter = new MoodAdapter(getActivity(), moodslist);
        myAdapter.notifyDataSetChanged();
        recyclerView = rootview.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myAdapter);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);



        return rootview;
    }





}
