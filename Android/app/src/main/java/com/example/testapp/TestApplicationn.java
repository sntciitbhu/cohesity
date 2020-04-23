package com.example.testapp;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

public class TestApplicationn extends Application
{
    public static final String APPLICATION_ID = "62B689E9-8DFD-1BD6-FF35-AE5B5CF72A00";
    public static final String API_KEY = "16FDF832-0371-4749-FFF8-681B5D1D8F00";
    public static final String SERVER_URL = "http://api.backendless.com";
    public static BackendlessUser user;
    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}