package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.translate;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mockingbird.spinkevich.newwords.R;
import com.mockingbird.spinkevich.newwords.presentation.data.api.TranslateResponse;
import com.mockingbird.spinkevich.newwords.presentation.data.converter.TranslateHelper;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateFragment extends Fragment implements ChooseLanguageFragment.OnLanguagesSelected {

    public static final int FROM_LANGUAGE = 1;
    public static final int TO_LANGUAGE = 2;

    @BindView(R.id.from_language)
    TextView fromLanguage;
    @BindView(R.id.to_language)
    TextView toLanguage;
    @BindView(R.id.translate_direction)
    ImageView translateDirection;
    @BindView(R.id.translated_edit)
    EditText textForTranslation;
    @BindView(R.id.translation)
    TextView translation;
    @BindView(R.id.add_word)
    FloatingActionButton addWordButton;
    @BindView(R.id.ad_view)
    AdView adView;

    private TranslateViewModel translateViewModel;

    public TranslateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_translate, container, false);
        ButterKnife.bind(this, view);

        translateViewModel = ViewModelProviders.of(this).get(TranslateViewModel.class);
        setupEditTextForTranslationedText();

        addWordButton.setOnClickListener(__ -> {
                    WordEntity wordEntity = createWordFromUI();
                    if (!wordEntity.getTranslation().isEmpty()) {
                        translateViewModel.insert(wordEntity);
                        // Create an ad request. Check logcat output for the hashed device ID to
                        // get test ads on a physical device. e.g.
                        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
                        AdRequest adRequest = new AdRequest.Builder()
                                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                                .build();
                        adView.loadAd(adRequest);
                    } else {
                        Toasty.error(getContext(), getResources().getString(R.string.translation_error)).show();
                    }
                }
        );

        fromLanguage.setOnClickListener(__ -> {
            ChooseLanguageFragment dialog = new ChooseLanguageFragment();
            dialog.setTargetFragment(TranslateFragment.this, FROM_LANGUAGE);
            dialog.show(getFragmentManager(), ChooseLanguageFragment.TAG);
        });
        toLanguage.setOnClickListener(__ -> {
            ChooseLanguageFragment dialog = new ChooseLanguageFragment();
            dialog.setTargetFragment(TranslateFragment.this, TO_LANGUAGE);
            dialog.show(getFragmentManager(), ChooseLanguageFragment.TAG);
        });

        return view;
    }

    private WordEntity createWordFromUI() {
        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord(textForTranslation.getText().toString());
        wordEntity.setTranslation(translation.getText().toString());
        wordEntity.setTranslateDirection(getTranslateDirection());
        wordEntity.setTimeStamp(Calendar.getInstance().getTime());
        return wordEntity;
    }

    private String getTranslateDirection() {
        return TranslateHelper.getLanguageCode(fromLanguage.getText().toString()) +
                "-" +
                TranslateHelper.getLanguageCode(toLanguage.getText().toString());
    }

    private void setupEditTextForTranslationedText() {
        textForTranslation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            Handler handler = new Handler(Looper.getMainLooper());
            Runnable runnable;
            private final long DELAY = 500;

            @Override
            public void afterTextChanged(Editable editable) {
                handler.removeCallbacks(runnable);
                runnable = () -> handleString(editable.toString());
                handler.postDelayed(runnable, DELAY);
            }

            private void handleString(String s) {
                translateViewModel.translate(getTranslateDirection(), s)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                data -> showData(data),
                                error -> System.out.print(error)
                        );
            }
        });
    }

    private void showData(TranslateResponse data) {
        translation.setText(data.getTranslation().get(0));
    }

    @Override
    public void selectLanguage(String language, int result) {
        switch (result) {
            case FROM_LANGUAGE:
                fromLanguage.setText(language);
                translateViewModel.setFromLanguage(language);
                break;
            case TO_LANGUAGE:
                toLanguage.setText(language);
                translateViewModel.setToLanguage(language);
                break;
        }
    }
}
