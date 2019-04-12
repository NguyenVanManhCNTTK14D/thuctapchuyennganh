package com.example.nguyenmanh.gogo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nguyenmanh.gogo.Adapter.AlbumAdapter;
import com.example.nguyenmanh.gogo.Adapter.theloaiAdapter;
import com.example.nguyenmanh.gogo.Model.Album;
import com.example.nguyenmanh.gogo.Model.Theloai;
import com.example.nguyenmanh.gogo.R;
import com.example.nguyenmanh.gogo.Server.APIService;
import com.example.nguyenmanh.gogo.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_chude_theloai extends Fragment {
    View view;
    RecyclerView recyclerViewtheloai;
    TextView txtxemthemtheloai;
    theloaiAdapter theloaiAdapter2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chudetheloai,container,false);
        recyclerViewtheloai = view.findViewById(R.id.recyclerviewtheloai);
        txtxemthemtheloai = view.findViewById(R.id.textviewxemthemtheloai);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetTheLoai();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai>theloaiArrayList = (ArrayList<Theloai>) response.body();
                theloaiAdapter2 = new theloaiAdapter(getActivity(),theloaiArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewtheloai.setLayoutManager(linearLayoutManager);
                recyclerViewtheloai.setAdapter(theloaiAdapter2);



            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {

            }
        });
    }
}
