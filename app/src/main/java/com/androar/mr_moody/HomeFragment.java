package com.androar.mr_moody;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Date;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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
public class HomeFragment extends Fragment  {

    TextView tvWelcome;

    //Data starrt
    private MainActivity activity;

    @Override
    public void onAttach(Activity activity) {
        this.activity = (MainActivity) activity;
        super.onAttach(activity);
    }

    //Data End



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
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mood = input.getText().toString();
                        if (mood != null) {
                            Bundle data = new Bundle();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
                            String currentDateandTime = sdf.format(new Date());
                            Mood moods = new Mood("happy",mood,currentDateandTime);
                            data.putSerializable("moods", moods);
                            ((MainActivity)getActivity()).saveData(data);
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
                Toast.makeText(getActivity(), "Glad that you're smiling!", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("What's making you smile today? ");
                builder.setMessage("It's easier to track thoughts if you note them down");
                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mood = input.getText().toString();
                        if (mood != null) {
                            Bundle data = new Bundle();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
                            String currentDateandTime = sdf.format(new Date());
                            Mood moods = new Mood("smile",mood,currentDateandTime);
                            data.putSerializable("moods", moods);
                            ((MainActivity)getActivity()).saveData(data);
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


        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Aww, Cheer up!", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("What's making you sad today? ");
                builder.setMessage("It's easier to track thoughts if you note them down");
                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mood = input.getText().toString();
                        if (mood != null) {
                            Bundle data = new Bundle();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
                            String currentDateandTime = sdf.format(new Date());
                            Mood moods = new Mood("sad",mood,currentDateandTime);
                            data.putSerializable("moods", moods);
                            ((MainActivity)getActivity()).saveData(data);
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

        ivFucked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Oh, that's bad!", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("What's making you feel so angry today? ");
                builder.setMessage("It's easier to track thoughts if you note them down");
                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setCancelable(false);
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mood = input.getText().toString();
                        if (mood != null) {
                            Bundle data = new Bundle();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm");
                            String currentDateandTime = sdf.format(new Date());
                            Mood moods = new Mood("fucked",mood,currentDateandTime);
                            data.putSerializable("moods", moods);
                            ((MainActivity)getActivity()).saveData(data);
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
        //Button Count ends

        return myview;
    }




}
