package com.application.kurukshetrauniversitypapers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

public class Filters extends AppCompatActivity {

   //private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        //toolbar=(Toolbar)findViewById(R.id.myToolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.myViewPager);

       // setSupportActionBar(toolbar);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);



    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new PapersFragment(),"Papers");
        viewPagerAdapter.addFragment(new SyllabusFragment(),"Syllabus");
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