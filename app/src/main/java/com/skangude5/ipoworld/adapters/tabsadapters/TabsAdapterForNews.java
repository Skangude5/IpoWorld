package com.skangude5.ipoworld.adapters.tabsadapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOListed;
import com.skangude5.ipoworld.ui.main_ipo.main_ipo_status.MainIPOUpcoming;
import com.skangude5.ipoworld.ui.news.news_category.CryptoMarketNews;
import com.skangude5.ipoworld.ui.news.news_category.StockMarketNews;

public class TabsAdapterForNews extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapterForNews(FragmentManager fm, int NoofTabs){
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
                StockMarketNews stockMarketNews = new StockMarketNews();
                return stockMarketNews;
            case 1:
                CryptoMarketNews cryptoMarketNews = new CryptoMarketNews();
                return cryptoMarketNews;
            default:
                return null;
        }
    }
}
