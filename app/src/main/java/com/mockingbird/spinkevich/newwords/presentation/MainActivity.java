package com.mockingbird.spinkevich.newwords.presentation;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mockingbird.spinkevich.newwords.R;
import com.mockingbird.spinkevich.newwords.presentation.presentation.feature.study.StudyFragment;
import com.mockingbird.spinkevich.newwords.presentation.presentation.feature.translate.TranslateFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        // we went from widget
        if (getIntent() != null && getIntent().getAction() == null) {
            viewPager.setCurrentItem(1);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        SimpleFragmentAdapter adapter = new SimpleFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new TranslateFragment());
        adapter.addFragment(new StudyFragment());
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_translate));
        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_study));
    }
}
