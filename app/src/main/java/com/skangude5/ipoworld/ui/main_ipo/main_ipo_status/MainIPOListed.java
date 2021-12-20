package com.skangude5.ipoworld.ui.main_ipo.main_ipo_status;

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
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.ClickListener;
import com.skangude5.ipoworld.adapters.recyclerviewadapters.recyclerviewutils.RecyclerTouchListener;

public class MainIPOListed extends Fragment {
    private RecyclerView recyclerViewForMainIPOListed;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_ipo_listed,container,false);
        recyclerViewForMainIPOListed = root.findViewById(R.id.recycler_view_for_main_ipo_listed);
        String[] temp = new String[10];
        for(int i=1;i<11;i++){
            temp[i-1] = "Listed Main IPO " + Integer.toString(i) + " information";
        }
        recyclerViewForMainIPOListed.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapterForMainIPOForListed customRecyclerViewAdapterForMainIPOForListed = new CustomRecyclerViewAdapterForMainIPOForListed(temp);
        //recyclerViewForMainIPOListed.addItemDecoration(new DividerItemDecoration(recyclerViewForMainIPOListed.getContext(),DividerItemDecoration.VERTICAL));
        recyclerViewForMainIPOListed.setAdapter(customRecyclerViewAdapterForMainIPOForListed);

        //recyclerView clicklistner
        recyclerViewForMainIPOListed.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerViewForMainIPOListed, new ClickListener() {
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
