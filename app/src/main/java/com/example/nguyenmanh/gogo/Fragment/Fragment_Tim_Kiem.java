package com.example.nguyenmanh.gogo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.nguyenmanh.gogo.Adapter.seachbaihatadapter;
import com.example.nguyenmanh.gogo.Model.Baihat;
import com.example.nguyenmanh.gogo.R;
import com.example.nguyenmanh.gogo.Server.APIService;
import com.example.nguyenmanh.gogo.Server.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Tim_Kiem extends Fragment {
    View view;
    Toolbar toolbar;
    RecyclerView recyclerViewseachbaihat;
    TextView txtkhongcodulieu;
    seachbaihatadapter seachbaihatadapter2;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_tim_kiem,container,false);
        toolbar = view.findViewById(R.id.toolbarseachbaihat);
        recyclerViewseachbaihat = view.findViewById(R.id.recyclerviewseachbaihat);
        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.seach_view,menu);
        MenuItem menuItem = menu.findItem(R.id.menu_seach);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchtukhoa(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private void searchtukhoa(String query){
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.Getseachbaihat(query);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> mangbaihat = (ArrayList<Baihat>) response.body();
                if (mangbaihat.size() > 0){
                    seachbaihatadapter2 = new seachbaihatadapter(getActivity(),mangbaihat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewseachbaihat.setLayoutManager(linearLayoutManager);
                    recyclerViewseachbaihat.setAdapter(seachbaihatadapter2);

                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewseachbaihat.setVisibility(View.VISIBLE);
                }else{
                    recyclerViewseachbaihat.setVisibility(View.GONE);
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }
}
