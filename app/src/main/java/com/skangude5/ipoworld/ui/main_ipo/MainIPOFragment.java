package com.skangude5.ipoworld.ui.main_ipo;

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
import com.skangude5.ipoworld.adapters.tabsadapters.TabsAdapterForMainIPO;
import com.skangude5.ipoworld.databinding.FragmentMainIpoBinding;

public class MainIPOFragment extends Fragment {

    private MainIPOViewModel mainIPOViewModel;
    private FragmentMainIpoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mainIPOViewModel =
                new ViewModelProvider(this).get(MainIPOViewModel.class);

        binding = FragmentMainIpoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //////////////////////////////////////
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout_for_main_ipo);
        tabLayout.addTab(tabLayout.newTab().setText("Current & Upcoming"));
        tabLayout.addTab(tabLayout.newTab().setText("Listed"));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_upcoming_header_icon_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_outline_listed_header_icon_24);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =(ViewPager)root.findViewById(R.id.pager_layout_for_main_ipo);
        TabsAdapterForMainIPO tabsAdapterForMainIPO = new TabsAdapterForMainIPO(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapterForMainIPO);
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
        ////////////////////////////////////
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}