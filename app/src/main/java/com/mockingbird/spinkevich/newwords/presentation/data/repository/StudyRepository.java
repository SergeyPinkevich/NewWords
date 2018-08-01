package com.mockingbird.spinkevich.newwords.presentation.data.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.mockingbird.spinkevich.newwords.presentation.data.db.WordDatabase;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import java.util.List;

public class StudyRepository {

    private WordDatabase database;

    public StudyRepository(Application application) {
        database = WordDatabase.getWordDatabase(application);
    }

    public LiveData<List<WordEntity>> getWords() {
        return database.wordDao().getAll();
    }

    public void deleteAllWords() {
        new DeleteAsyncTask(database).execute();
    }

    private static class DeleteAsyncTask extends AsyncTask<Void, Void, Void> {

        private WordDatabase database;

        DeleteAsyncTask(WordDatabase database) {
            this.database = database;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.wordDao().deleteAll();
            return null;
        }
    }
}
