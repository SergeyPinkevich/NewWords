package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.translate;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateResponse;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;
import com.mockingbird.spinkevich.newwords.presentation.data.repository.TranslateRepository;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.component.DaggerAppComponent;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.AppModule;

import javax.inject.Inject;

import io.reactivex.Single;

public class TranslateViewModel extends AndroidViewModel {

    private MutableLiveData<TranslateResponse> translateLiveData;

    private String fromLanguage;
    private String toLanguage;

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

    public Single<TranslateResponse> translate(String translationDirection, String text) {
        return translateRepository.translate(translationDirection, text);
    }

    public MutableLiveData<TranslateResponse> getTranslateLiveData() {
        if (translateLiveData == null) {
            translateLiveData = new MutableLiveData();
        }
        return translateLiveData;
    }

    public String getFromLanguage() {
        return fromLanguage;
    }

    public void setFromLanguage(String fromLanguage) {
        this.fromLanguage = fromLanguage;
    }

    public String getToLanguage() {
        return toLanguage;
    }

    public void setToLanguage(String toLanguage) {
        this.toLanguage = toLanguage;
    }
}
