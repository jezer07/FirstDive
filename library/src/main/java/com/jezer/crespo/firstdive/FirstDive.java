package com.jezer.crespo.firstdive;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jezer Crespo on 11/6/15.
 */
public class FirstDive {


    private static final String FIRST_LAUNCH = "FirstDive";
    private static final String HAS_LAUNCHED = "HAS_LAUNCHED";
    private Context mContext;
    private SharedPreferences mPref;
    private static FirstDive mInstance;

    private FirstDive(Context c) {
        mContext = c;
        mPref = mContext.getSharedPreferences(FIRST_LAUNCH, Context.MODE_PRIVATE);
    }

    /**
     * Retrieves the singleton of FirstDive object.
     *
     * @param c Context object
     * @return
     */

    public static FirstDive getInstance(Context c) {
        if (mInstance == null)
            mInstance = new FirstDive(c);

        return mInstance;
    }

    /**
     * Executes the tasks inside the block only once, for the first time.
     * @param onFirstLaunch - implementation object of {@link #doOnFirstLaunch(OnFirstLaunch)}.
     */

    public void doOnFirstLaunch(OnFirstLaunch onFirstLaunch) {
        if (!mPref.contains(HAS_LAUNCHED)) {
            onFirstLaunch.doOnFirstLaunch();
            mPref.edit().putBoolean(HAS_LAUNCHED, true).commit();
        }
    }

    /**
     * Resets the first launch flag, doing so will make {@link #doOnFirstLaunch(OnFirstLaunch)} executed again
     * when the code execution went there.
     */
    public void resetLaunch() {
        if (mPref.contains(HAS_LAUNCHED)) {
            mPref.edit().remove(HAS_LAUNCHED).commit();
        }
    }

    /**
     * Retrieves the current state of first launch if {@link #doOnFirstLaunch(OnFirstLaunch)} has already run or not.
     * @return boolean value. true if doOnFirstLaunch has run, false if not yet.
     */
    public boolean hasFirstLaunched() {
        return mPref.getBoolean(HAS_LAUNCHED, false);
    }


}
