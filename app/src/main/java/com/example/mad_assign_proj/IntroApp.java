package com.example.mad_assign_proj;


import android.app.Application;

public class IntroApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Globals.init(this);
    }

}
