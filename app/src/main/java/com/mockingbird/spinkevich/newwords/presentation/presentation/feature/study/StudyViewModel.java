package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.study;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;
import com.mockingbird.spinkevich.newwords.presentation.data.repository.StudyRepository;

import java.util.List;

public class StudyViewModel extends AndroidViewModel {

    private StudyRepository studyRepository;
    private LiveData<List<WordEntity>> words;

    public StudyViewModel(@NonNull Application application) {
        super(application);
        studyRepository = new StudyRepository(this.getApplication());
        words = studyRepository.getWords();
    }

    public LiveData<List<WordEntity>> getWords() {
        return words;
    }
}
