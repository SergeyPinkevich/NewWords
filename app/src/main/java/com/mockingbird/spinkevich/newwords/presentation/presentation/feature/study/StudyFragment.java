package com.mockingbird.spinkevich.newwords.presentation.presentation.feature.study;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mockingbird.spinkevich.newwords.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private StudyViewModel studyViewModel;
    private WordAdapter adapter;

    public StudyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        ButterKnife.bind(this, view);

        adapter = new WordAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setWords(new ArrayList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        studyViewModel = ViewModelProviders.of(this).get(StudyViewModel.class);
        studyViewModel.getWords().observe(StudyFragment.this, wordEntities -> adapter.setWords(wordEntities));

        return view;
    }

}
