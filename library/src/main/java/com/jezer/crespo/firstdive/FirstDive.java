package com.jezer.crespo.firstdive;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by phjecr on 11/6/15.
 */
public class FirstDive {


    private static final String FIRST_LAUNCH = "FirstDive";
    private static final String HAS_LAUNCHED = "HAS_LAUNCHED";
    private Context mContext;
    private SharedPreferences mPref;
    private static FirstDive mInstance;

     private FirstDive(Context c) {
        mContext = c;
        mPref = mContext.getSharedPreferences(FIRST_LAUNCH,Context.MODE_PRIVATE);
    }

    public static FirstDive getInstance(Context c){
        if(mInstance==null)
            return new FirstDive(c);
        else
              return mInstance;
    }



    public void doOnFirstLaunch(OnFirstLaunch onFirstLaunch){
        if(!mPref.contains(HAS_LAUNCHED)) {
            onFirstLaunch.doOnFirstLaunch();
            mPref.edit().putBoolean(HAS_LAUNCHED, true).commit();
        }
    }
    public void resetLaunch(){
        if(mPref.contains(HAS_LAUNCHED)) {
            mPref.edit().remove(HAS_LAUNCHED).commit();
        }


    }



}
