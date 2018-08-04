package com.mockingbird.spinkevich.newwords.presentation.data.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import com.mockingbird.spinkevich.newwords.BuildConfig;
import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateResponse;
import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateService;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordDatabase;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class TranslateRepository {

    private Context context;
    private TranslateService service;

    @Inject
    public TranslateRepository(Application application,
                               TranslateService service) {
        context = application;
        this.service = service;
    }

    public Single<TranslateResponse> translate(String translateDirection, String textForTranslation) {
        return service.translate(BuildConfig.ApiKey, translateDirection, textForTranslation);
    }

    public void insert(WordEntity word) {
        new InsertAsyncTask(WordDatabase.getWordDatabase(context)).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<WordEntity, Void, Void> {

        private WordDatabase database;

        InsertAsyncTask(WordDatabase database) {
            this.database = database;
        }

        @Override
        protected Void doInBackground(final WordEntity... params) {
            database.wordDao().insert(params[0]);
            return null;
        }
    }
}
