package com.mockingbird.spinkevich.newwords.presentation.presentation.di.module;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateService;
import com.readystatesoftware.chuck.ChuckInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public static final String BASE_URL = "https://translate.yandex.net/";

    @Singleton
    @Provides
    Retrofit provideRetrofit(Context context) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(httpClient)
                .build();
    }

    @Singleton
    @Provides
    TranslateService provideApiService(Retrofit retrofit) {
        return retrofit.create(TranslateService.class);
    }
}
