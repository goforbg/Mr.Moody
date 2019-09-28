package com.androar.mr_moody;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;
import static com.androar.mr_moody.MainActivity.mypreference;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView tvWelcome;

    String user;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "com.androar.mr_moody";



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview = inflater.inflate(R.layout.fragment_home, container, false);
        tvWelcome = (TextView) myview.findViewById(R.id.tvWelcome);
        sharedPreferences = this.getActivity().getSharedPreferences(mypreference, MODE_PRIVATE);
        user = sharedPreferences.getString("Name", "cupcake");
        tvWelcome.setText("Hi there, "+ user + "!");
        return myview;

    }



}
