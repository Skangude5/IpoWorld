package com.skangude5.ipoworld.ui.sme_ipo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.skangude5.ipoworld.R;
import com.skangude5.ipoworld.adapters.TabsAdapterForMainIPO;
import com.skangude5.ipoworld.adapters.TabsAdapterForSmeIPO;
import com.skangude5.ipoworld.databinding.FragmentSmeIpoBinding;

public class SmeIPOFragment extends Fragment {

    private SmeIPOViewModel smeIPOViewModel;
    private FragmentSmeIpoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        smeIPOViewModel =
                new ViewModelProvider(this).get(SmeIPOViewModel.class);

        binding = FragmentSmeIpoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        smeIPOViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        ///////////////////////////////////////////////////
        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout_for_sme_ipo);
        tabLayout.addTab(tabLayout.newTab().setText("Current & Upcoming"));
        tabLayout.addTab(tabLayout.newTab().setText("Listed"));
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_upcoming_header_icon_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_outline_listed_header_icon_24);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager =(ViewPager)root.findViewById(R.id.pager_layout_for_sme_ipo);
        TabsAdapterForSmeIPO tabsAdapterForSmeIPO = new TabsAdapterForSmeIPO(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapterForSmeIPO);
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
        //////////////////////////////////////////////////
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}