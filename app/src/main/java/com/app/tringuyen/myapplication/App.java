package com.app.tringuyen.myapplication;

import android.app.Application;

/**
 * Created by Tri Nguyen on 9/14/2016.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       FirebaseHelper.getInstance();
    }
}
