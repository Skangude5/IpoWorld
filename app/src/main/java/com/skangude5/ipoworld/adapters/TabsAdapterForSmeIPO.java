package com.skangude5.ipoworld.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOListed;
import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOUpcoming;
import com.skangude5.ipoworld.ui.sme_ipo.sme_ipo_status.SmeIPOListed;
import com.skangude5.ipoworld.ui.sme_ipo.sme_ipo_status.SmeIPOUpcoming;

public class TabsAdapterForSmeIPO extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapterForSmeIPO(FragmentManager fm, int NoofTabs){
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
                SmeIPOUpcoming smeUpcoming = new SmeIPOUpcoming();
                return smeUpcoming;
            case 1:
                SmeIPOListed smeListed = new SmeIPOListed();
                return smeListed;
            default:
                return null;
        }
    }
}
