package com.androar.mr_moody;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.androar.mr_moody.MainActivity.mypreference;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView tvWelcome;

    MainActivityViewModel viewModel;

    String user;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "com.androar.mr_moody";



    //Declarations for Imageviews start
    int ivHappyCount, ivSmileCount, ivSadCount, ivFuckedCount;
    ImageView ivHappy, ivSmile, ivSad, ivFucked;
    //Declarations for Imageviews end



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(this.getActivity()).get(MainActivityViewModel.class);


        View myview = inflater.inflate(R.layout.fragment_home, container, false);
        tvWelcome = (TextView) myview.findViewById(R.id.tvWelcome);
        sharedPreferences = this.getActivity().getSharedPreferences(mypreference, MODE_PRIVATE);
        user = sharedPreferences.getString("Name", "cupcake");
        tvWelcome.setText("Hi there, "+ user + "!");


        //Button Count starts
        ivHappy = (ImageView) myview.findViewById(R.id.ivHappy);
        ivSad = (ImageView) myview.findViewById(R.id.ivSad);
        ivSmile = (ImageView) myview.findViewById(R.id.ivSmile);
        ivFucked = (ImageView) myview.findViewById(R.id.ivFucked);


        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ivHappyCount++;
                Toast.makeText(getActivity(), "Glad that you're on the top of the world!", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("What's making you happy today? ");
                builder.setMessage("It's easier to track thoughts if you note them down");
                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                final String mood = input.getText().toString();
                builder.setCancelable(false);
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("String mood is", mood);
                        if (mood != null) {
                            viewModel.selectMood(mood);
                            //model.setsValue(mood);
                            Toast.makeText(getActivity(), "Set!", Toast.LENGTH_SHORT).show();
                        }

                        else
                            {
                                Toast.makeText(getActivity(), "Okay!", Toast.LENGTH_SHORT).show();
                            }
                    }
                });
                builder.create();
                builder.show();
            }
        });


        ivSmile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivSmileCount++;
                Toast.makeText(getActivity(), "Keep smilin' darling! ", Toast.LENGTH_SHORT).show();
            }
        });


        ivFucked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivFuckedCount++;
                Toast.makeText(getActivity(), "It's going to be okay. Take a deep breath.", Toast.LENGTH_SHORT).show();
            }
        });


        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivSadCount++;
                Toast.makeText(getActivity(), "Aww, what's bothering you?", Toast.LENGTH_SHORT).show();
            }
        });
        //Button Count ends




        return myview;
    }



}
