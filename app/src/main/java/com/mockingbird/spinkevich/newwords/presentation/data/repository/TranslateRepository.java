package com.mockingbird.spinkevich.newwords.presentation.data.repository;

import android.app.Application;
import android.content.Context;

import com.mockingbird.spinkevich.newwords.BuildConfig;
import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateResponse;
import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateService;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordDatabase;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TranslateRepository {

    Context context;
    TranslateService service;

    @Inject
    public TranslateRepository(Application application,
                               TranslateService service) {
        context = application;
        this.service = service;
    }

    public void translate(String translateDirection, String textForTranslation) {
        service.translate(BuildConfig.ApiKey, translateDirection, textForTranslation)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<TranslateResponse>() {
                    @Override
                    public void onSuccess(TranslateResponse translateResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void insert(WordEntity word) {
        WordDatabase.getWordDatabase(context).wordDao().insert(word);
    }
}
