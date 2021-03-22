package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import Adapters.ViewPagerAdapter;

public class Filters extends AppCompatActivity {

   //private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public int extrasPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);
        Intent intent = getIntent();
        if(intent == null) {
            extrasPosition = 0;
        } else {
            extrasPosition = intent.getIntExtra("position", 0);
        }

        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.myViewPager);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(extrasPosition);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new PapersFragment(),"Papers");
        viewPagerAdapter.addFragment(new SyllabusFragment(),"Syllabus");
        viewPagerAdapter.addFragment(new SolutionsFragment(),"Solutions");
        viewPagerAdapter.addFragment(new VideoFragment(),"Videos");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(Filters.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("run counter","no");
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}