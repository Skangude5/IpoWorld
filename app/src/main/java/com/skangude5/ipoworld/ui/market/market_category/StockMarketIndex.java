package com.skangude5.ipoworld.ui.market.market_category;

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
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewformarket.CustomRecyclerViewAdapterForMarketForCryptoMarket;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewformarket.CustomRecyclerViewAdapterForMarketForStockMarket;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.ClickListener;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.RecyclerTouchListener;

public class StockMarketIndex extends Fragment {
    private RecyclerView recyclerViewForMarketStockMarket;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_market_stock_market_index,container,false);

        recyclerViewForMarketStockMarket = root.findViewById(R.id.recycler_view_for_market_stock_market);
        String[] temp = new String[4];
        temp[0] = "NIFTY";
        temp[1] = "BANKNIFTY";
        temp[2] = "SENSEX";
        temp[3] = "FINNIFTY";
        recyclerViewForMarketStockMarket.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapterForMarketForStockMarket customRecyclerViewAdapterForMarketForStockMarket = new CustomRecyclerViewAdapterForMarketForStockMarket(temp);
        recyclerViewForMarketStockMarket.addItemDecoration(new DividerItemDecoration(recyclerViewForMarketStockMarket.getContext(),DividerItemDecoration.VERTICAL));
        recyclerViewForMarketStockMarket.setAdapter(customRecyclerViewAdapterForMarketForStockMarket);

        //recyclerView clicklistner
        recyclerViewForMarketStockMarket.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewForMarketStockMarket, new ClickListener() {
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
