package com.example.nguyenmanh.gogo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.nguyenmanh.gogo.Adapter.ALLAlbumAdapter;
import com.example.nguyenmanh.gogo.Model.Album;
import com.example.nguyenmanh.gogo.R;
import com.example.nguyenmanh.gogo.Server.APIService;
import com.example.nguyenmanh.gogo.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcacalbumActivity extends AppCompatActivity {
    RecyclerView recyclerViewallalbum;
    Toolbar toolbaralbum;
    ALLAlbumAdapter allAlbumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcacalbum);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum = (ArrayList<Album>) response.body();
                allAlbumAdapter = new ALLAlbumAdapter(DanhsachcacalbumActivity.this,mangalbum);
                recyclerViewallalbum.setLayoutManager(new GridLayoutManager(DanhsachcacalbumActivity.this,2));
                recyclerViewallalbum.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewallalbum = findViewById(R.id.recyclerviewallalbum);
        toolbaralbum = findViewById(R.id.toolbarallalbum);
        setSupportActionBar(toolbaralbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("tất cả album");
        toolbaralbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
