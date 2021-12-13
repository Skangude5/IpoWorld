package com.skangude5.ipoworld.adapters.tabsadapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOListed;
import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOUpcoming;

public class TabsAdapterForMainIPO extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapterForMainIPO(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                MainIPOUpcoming upcoming = new MainIPOUpcoming();
                return upcoming;
            case 1:
                MainIPOListed listed = new MainIPOListed();
                return listed;
            default:
                return null;
        }
    }
}
