package com.androar.mr_moody;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
