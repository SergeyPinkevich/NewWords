package com.mockingbird.spinkevich.newwords.presentation.presentation.di;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.mockingbird.spinkevich.newwords.R;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.component.AppComponent;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.component.DaggerAppComponent;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.AppModule;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.NetworkModule;

public class BaseApp extends Application {

    public static AppComponent component;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
        sAnalytics = GoogleAnalytics.getInstance(this);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
}
