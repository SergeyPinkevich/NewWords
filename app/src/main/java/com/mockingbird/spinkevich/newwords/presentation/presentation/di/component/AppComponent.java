package com.mockingbird.spinkevich.newwords.presentation.presentation.di.component;

import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.AppModule;
import com.mockingbird.spinkevich.newwords.presentation.presentation.di.module.NetworkModule;
import com.mockingbird.spinkevich.newwords.presentation.presentation.feature.translate.TranslateViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(TranslateViewModel viewModel);
}
