package com.application.kurukshetrauniversitypapers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentsList=new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PapersFragment();
            case 1:
                return new SyllabusFragment();
            case 2:
                return new SolutionsFragment();
            case 3:
                return new VideoFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return fragmentsList.size();
    }
    public void addFragment(Fragment fragment,String title){
        fragmentsList.add(fragment);
        fragmentTitle.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
