package com.example.drawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new Basic_Projects();
        }else if(position == 1){
            return new Intermediate();
        }else if(position == 2){
            return new Advance();
        }else {
            return new DailyNeeds();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0){
            return "Basic";
        }else if(position == 1){
            return "Intermediate";
        }else if(position == 2){
            return "Advance";
        }else {
            return "Daily Needs";
        }
    }
}
