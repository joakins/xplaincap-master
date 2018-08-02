package com.xplaincap.application;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.xplaincap.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by emnity on 5/19/17.
 */

public class Xplaincap extends Application {
    private static final String TAG = Xplaincap.class.getSimpleName();
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        sAnalytics = GoogleAnalytics.getInstance(this);
    }

    synchronized public Tracker getDefaultTracker() {
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }
        return sTracker;
    }

    public String getRawFile(int res) {
        InputStream inputStream = null;
        String fileData = null;
        try {
            inputStream = getApplicationContext().getResources().openRawResource(res);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            fileData = new String(buffer, "UTF-8");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Could not find the file");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e(TAG, "IO Error");
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileData;
    }

}
