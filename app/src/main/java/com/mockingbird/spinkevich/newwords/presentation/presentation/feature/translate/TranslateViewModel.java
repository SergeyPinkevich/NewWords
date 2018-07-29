package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.translate;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;
import com.mockingbird.spinkevich.newwords.presentation.data.repository.TranslateRepository;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.component.DaggerAppComponent;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.AppModule;

import javax.inject.Inject;

public class TranslateViewModel extends AndroidViewModel {

    @Inject
    TranslateRepository translateRepository;

    public TranslateViewModel(@NonNull Application application) {
        super(application);
        DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build()
                .inject(this);
    }

    public void insert(WordEntity wordEntity) {
        translateRepository.insert(wordEntity);
    }

    public void translate(String translationDirection, String text) {
        translateRepository.translate(translationDirection, text);
    }
}
