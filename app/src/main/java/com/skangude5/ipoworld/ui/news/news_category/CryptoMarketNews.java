package com.skangude5.ipoworld.ui.news.news_category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skangude5.ipoworld.R;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewfornews.CustomRecyclerViewAdapterForNewsForCryptoMarket;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.ClickListener;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.RecyclerTouchListener;

public class CryptoMarketNews extends Fragment {
    private RecyclerView recyclerViewForNewsCryptoMarket;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_crypto_market_news,container,false);

        recyclerViewForNewsCryptoMarket = root.findViewById(R.id.recycler_view_for_news_crypto_market);
        String[] temp = new String[20];
        for(int i=1;i<21;i++){
            temp[i-1] = "Crypto News Headline No. " + Integer.toString(i);
        }
        recyclerViewForNewsCryptoMarket.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapterForNewsForCryptoMarket customRecyclerViewAdapterForNewsForCryptoMarket = new CustomRecyclerViewAdapterForNewsForCryptoMarket(temp);
        recyclerViewForNewsCryptoMarket.addItemDecoration(new DividerItemDecoration(recyclerViewForNewsCryptoMarket.getContext(),DividerItemDecoration.VERTICAL));
        recyclerViewForNewsCryptoMarket.setAdapter(customRecyclerViewAdapterForNewsForCryptoMarket);

        //recyclerView clicklistner
        recyclerViewForNewsCryptoMarket.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewForNewsCryptoMarket, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), "single tap on " + temp[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getContext(), "Long tap on " + temp[position], Toast.LENGTH_SHORT).show();
            }
        }));
        return root;
    }
}
