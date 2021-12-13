package com.skangude5.ipoworld.ui.market;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.skangude5.ipoworld.R;
import com.skangude5.ipoworld.adapters.tabsadapters.TabsAdapterForMarket;
import com.skangude5.ipoworld.databinding.FragmentMarketBinding;

public class MarketFragment extends Fragment {

    private MarketViewModel marketViewModel;
    private FragmentMarketBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        marketViewModel =
                new ViewModelProvider(this).get(MarketViewModel.class);

        binding = FragmentMarketBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textNotifications;
//        marketViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        ///////////////////////////////////////
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout_for_market);
        tabLayout.addTab(tabLayout.newTab().setText("Stock Market Indices"));
        tabLayout.addTab(tabLayout.newTab().setText("Crypto Coins"));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_market_bottom_nav_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_crypto_header_icon_24);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =(ViewPager)root.findViewById(R.id.pager_layout_for_market);
        TabsAdapterForMarket tabsAdapterForMarket = new TabsAdapterForMarket(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapterForMarket);
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
        //////////////////////////////////////
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}