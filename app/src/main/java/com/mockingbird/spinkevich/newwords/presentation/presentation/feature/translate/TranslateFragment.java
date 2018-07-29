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

import com.mockingbird.spinkevich.newwords.R;
import com.mockingbird.spinkevich.newwords.presentation.data.converter.TranslateHelper;
import com.mockingbird.spinkevich.newwords.presentation.data.db.WordEntity;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TranslateFragment extends Fragment {

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

        addWordButton.setOnClickListener(view1 -> {
            translateViewModel.insert(createWord());
        });

        return view;
    }

    private WordEntity createWord() {
        WordEntity wordEntity = new WordEntity();
        wordEntity.setWord(textForTranslation.getText().toString());
        wordEntity.setTranslation(translation.getText().toString());
        wordEntity.setTranslateDirection(getTranslateDirecton());
        wordEntity.setTimeStamp(Calendar.getInstance().getTime());
        return wordEntity;
    }

    private String getTranslateDirecton() {
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
                translateViewModel.translate(getTranslateDirecton(), s);
            }
        });
    }
}