package com.skangude5.ipoworld.ui.sme_ipo.sme_ipo_status;

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
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewforsmeipo.CustomRecyclerViewAdapterForSmeIPOForListed;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.ClickListener;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.RecyclerTouchListener;

public class SmeIPOListed extends Fragment {
    private RecyclerView recyclerViewForSmeIPOListed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sme_ipo_listed,container,false);

        recyclerViewForSmeIPOListed = root.findViewById(R.id.recycler_view_for_sme_ipo_listed);
        String[] temp = new String[20];
        for(int i=1;i<21;i++){
            temp[i-1] = "Listed Sme IPO " + Integer.toString(i) + " information";
        }
        recyclerViewForSmeIPOListed.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapterForSmeIPOForListed customRecyclerViewAdapterForSmeIPOForListed = new CustomRecyclerViewAdapterForSmeIPOForListed(temp);
        recyclerViewForSmeIPOListed.addItemDecoration(new DividerItemDecoration(recyclerViewForSmeIPOListed.getContext(),DividerItemDecoration.VERTICAL));
        recyclerViewForSmeIPOListed.setAdapter(customRecyclerViewAdapterForSmeIPOForListed);

        //recyclerView clicklistner
        recyclerViewForSmeIPOListed.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewForSmeIPOListed, new ClickListener() {
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
