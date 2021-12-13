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
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewformainipo.CustomRecyclerViewAdapterForMainIPOForListed;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewformarket.CustomRecyclerViewAdapterForMarketForCryptoMarket;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.ClickListener;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.RecyclerTouchListener;

public class CryptoMarketIndex extends Fragment {
    private RecyclerView  recyclerViewForMarketCryptoMarket;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_market_crypto_market_index,container,false);

        recyclerViewForMarketCryptoMarket = root.findViewById(R.id.recycler_view_for_market_crypto_market);
        String[] temp = new String[12];
        temp[0] = "Bitcoin";
        temp[1] = "Ethereum";
        temp[2] = "Litecoin ";
        temp[3] = "Cardano";
        temp[4] = "Polkadot";
        temp[5] = "Stellar";
        temp[6] = "Dogecoin";
        temp[7] = "Binance Coin";
        temp[8] = "Tether";
        temp[9] = "Monero";
        temp[10] = "Solana";
        temp[11] = "XRP";
        recyclerViewForMarketCryptoMarket.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapterForMarketForCryptoMarket customRecyclerViewAdapterForMarketForCryptoMarket = new CustomRecyclerViewAdapterForMarketForCryptoMarket(temp);
        recyclerViewForMarketCryptoMarket.addItemDecoration(new DividerItemDecoration(recyclerViewForMarketCryptoMarket.getContext(),DividerItemDecoration.VERTICAL));
        recyclerViewForMarketCryptoMarket.setAdapter(customRecyclerViewAdapterForMarketForCryptoMarket);

        //recyclerView clicklistner
        recyclerViewForMarketCryptoMarket.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewForMarketCryptoMarket, new ClickListener() {
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
