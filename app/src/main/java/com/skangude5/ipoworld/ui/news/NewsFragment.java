package com.skangude5.ipoworld.ui.news;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.skangude5.ipoworld.R;
import com.skangude5.ipoworld.adapters.TabsAdapterForMainIPO;
import com.skangude5.ipoworld.adapters.TabsAdapterForNews;
import com.skangude5.ipoworld.databinding.FragmentNewsBinding;

public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;
    private FragmentNewsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        newsViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        final TextView textView = binding.textNotifications;
//        newsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        ///////////////////////////////////////////////////////
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout_for_news);
        tabLayout.addTab(tabLayout.newTab().setText("Stock Market News"));
        tabLayout.addTab(tabLayout.newTab().setText("Crypto News"));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_market_bottom_nav_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_crypto_header_icon_24);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =(ViewPager)root.findViewById(R.id.pager_layout_for_news);
        TabsAdapterForNews tabsAdapterForNews = new TabsAdapterForNews(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapterForNews);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //////////////////////////////////////////////////////////
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}