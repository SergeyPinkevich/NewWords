package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.translate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mockingbird.spinkevich.newwords.R;
import com.mockingbird.spinkevich.newwords.presentation.data.converter.TranslateHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseLanguageFragment extends DialogFragment {

    public static final String TAG = "ChooseLanguageFragment";

    private OnLanguagesSelected onLanguagesSelected;

    @BindView(R.id.languages)
    ListView languagesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.languages_list, container, false);

        ButterKnife.bind(this, view);
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, TranslateHelper.getLanguages());
        languagesList.setAdapter(adapter);

        languagesList.setOnItemClickListener((adapterView, view1, position, id) -> {
            onLanguagesSelected.selectLanguage(TranslateHelper.getLanguages().get(position), getTargetRequestCode());
            getTargetFragment().onActivityResult(getTargetRequestCode(), getTargetRequestCode(), getActivity().getIntent());
            dismiss();
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
         super.onAttach(context);
         try {
             onLanguagesSelected = (OnLanguagesSelected) getTargetFragment();
         } catch (ClassCastException ex) {
             throw new ClassCastException(context.toString() + " must implement OnLanguagesSelected interface");
         }
    }

    public interface OnLanguagesSelected {
        void selectLanguage(String language, int code);
    }
}
