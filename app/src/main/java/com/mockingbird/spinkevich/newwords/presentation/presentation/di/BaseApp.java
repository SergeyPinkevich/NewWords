package com.mockingbird.spinkevich.newwords.presentation.presentation.di;

import android.app.Application;

import com.mockingbird.spinkevich.newwords.presentation.presentation.di.component.AppComponent;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.component.DaggerAppComponent;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.AppModule;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.NetworkModule;

public class BaseApp extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }
}
