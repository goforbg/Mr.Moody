package com.androar.mr_moody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //Declaration for Bottom Navigation and Fragments start
    private BottomNavigationView mMainNav;
    private FrameLayout home_layout;
    private HomeFragment homeFragment;
    private HistoryFragment historyFragment;
    //Declaration for Bottom Navigation and Fragments end


    //Declarations for First Run and Welcome starts
    TextView tvWelcome;
    String user;
    String userInputValue;
    SharedPreferences sharedPreferences;
    public static final String mypreference = "com.androar.mr_moody";
    //Declarations for first run and welcome ends

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //fragment and bottom nav switching starts
        home_layout = findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        historyFragment = new HistoryFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)

            {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_history:
                        setFragment(historyFragment);
                        return true;


                    default: setFragment(homeFragment);
                    return true;
                }
            }
        });
        //fragment and bottom nav switching ends


        //First run and Welcome text starts
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        sharedPreferences = getSharedPreferences(mypreference, MODE_PRIVATE);
        user = sharedPreferences.getString("Name", "cupcake");

        int first_run = checkFirstRun();
        if (first_run == 1)
        {
            AlertDialog.Builder alertDialogBox = new AlertDialog.Builder(this);
            alertDialogBox.setTitle("Hey, welcome to the Mr.Moody");
            alertDialogBox.setMessage("It's okay to feel what you feel. What do you like to be called?");


            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            alertDialogBox.setView(input);

            alertDialogBox.setCancelable(false);
            alertDialogBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    userInputValue = input.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name", userInputValue);
                    editor.commit();
                }
            });

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name", userInputValue);
            editor.commit();
            alertDialogBox.create();
            alertDialogBox.show();
        }



    } //onCreate Ends

    private void setFragment (Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    private int checkFirstRun() {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;
        int result=0;

        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            // This is just a normal run
            result = 0;

        } else if (savedVersionCode == DOESNT_EXIST) {

            result = 1;
            // TODO This is a new install (or the user cleared the shared preferences)

        } else if (currentVersionCode > savedVersionCode) {

            result = 0;
            // TODO This is an upgrade
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
        return result;
    }

}




