package com.skangude5.ipoworld.adapters.tabsadapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOListed;
import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOUpcoming;
import com.skangude5.ipoworld.ui.market.market_category.CryptoMarketIndex;
import com.skangude5.ipoworld.ui.market.market_category.StockMarketIndex;

public class TabsAdapterForMarket extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapterForMarket(FragmentManager fm, int NoofTabs){
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
                StockMarketIndex stockMarketIndex = new StockMarketIndex();
                return stockMarketIndex;
            case 1:
                CryptoMarketIndex cryptoMarketIndex = new CryptoMarketIndex();
                return cryptoMarketIndex;
            default:
                return null;
        }
    }
}
