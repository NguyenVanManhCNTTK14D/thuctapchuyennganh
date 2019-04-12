package com.example.nguyenmanh.gogo.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenmanh.gogo.Activity.PlayNhacActivity;
import com.example.nguyenmanh.gogo.Adapter.playnhacadapter;
import com.example.nguyenmanh.gogo.R;

public class Fragment_play_danh_sach_baihat extends Fragment {
    View view;
    RecyclerView recyclerViewplaynhac;
    playnhacadapter playnhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_play_danh_sach_baihat,container,false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewplaybaihat);
        if (PlayNhacActivity.mangbaihat.size()>0){
            playnhacAdapter = new playnhacadapter(getActivity(),PlayNhacActivity.mangbaihat);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playnhacAdapter);
        }

        return view;
    }
}
