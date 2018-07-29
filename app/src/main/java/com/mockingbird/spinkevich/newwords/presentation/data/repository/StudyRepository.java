package com.mockingbird.spinkevich.newwords.presentation.data.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.mockingbird.spinkevich.newwords.presentation.data.db.WordDatabase;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class StudyRepository {

    Context context;
    private static LiveData<List<WordEntity>> data;

    public StudyRepository(Application application) {
        context = application;
    }

    public LiveData<List<WordEntity>> getWords() {
        Observable.fromCallable(() -> WordDatabase.getWordDatabase(context).wordDao().getAll())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<LiveData<List<WordEntity>>>() {
                    @Override
                    public void onNext(LiveData<List<WordEntity>> listLiveData) {
                        data = listLiveData;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return data;
    }
}
