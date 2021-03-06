package org.mamkschools.mhs.fbla_mobileapp_2016.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;

/**
 * Constants for App, for use across app
 * Created by Andrew on 10/16/2015.
 */
public final class Constants {
    //API URL
    //Dev: public static final String API_BASE_URL = "https://ec2-54-152-175-225.compute-1.amazonaws.com/fbla2016/api/";
    //Prod:
    public static final String API_BASE_URL  = "https://ec2-52-3-127-219.compute-1.amazonaws.com/fbla2016/api/";
    //Old: public static final String API_BASE_URL = "https://aakatz3.aakportfolio.com:9084/fbla2016/api/";
    //Demo: public static final String API_BASE_URL = "https://192.168.1.5/fbla2016/api/";


    //Authcode needs to be saved and loaded
    public static String AUTHCODE = null;

    //Output debug info
    public static final boolean DEBUG_MODE = true;

    //Variable to see if prefs restored yet
    public static boolean PREFS_RESTORED = false;

    //Variables to store the user's latitude and longitude
    public static double LATITUDE;
    public static double LONGITUDE;

    //Single ImageBitmap for most bitmaps; *should* help with memory usage
    public static Bitmap imageBitmap = null;

    //Constant to deal with Demo Mode: sets time to 0 or 1 hours, and miles away to 0
    public static final boolean DEMO_MODE = false;

    private Constants(){
        //Do nothing constructor, exists to defeat instantiation.
    }

    public static void restorePrefs(Context ctx){
        PREFS_RESTORED = true;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        LATITUDE = Double.parseDouble(prefs.getString("LATITUDE", "37.42200"));
        LONGITUDE = Double.parseDouble(prefs.getString("LONGITUDE", "-122.084095"));
        AUTHCODE = prefs.getString("AUTHCODE", null);
    }

    @SuppressLint("CommitPrefEdits")
    public static void savePrefs(Context ctx, boolean aSync){

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("AUTHCODE", AUTHCODE);
        editor.putString("LATITUDE", Double.toString(LATITUDE));
        editor.putString("LONGITUDE", Double.toString(LONGITUDE));

        if(aSync){
            editor.apply();
        } else {
            // Commit the edits! Do not change to "apply" or will not be done because app will close!
            editor.commit();
        }
    }
}
