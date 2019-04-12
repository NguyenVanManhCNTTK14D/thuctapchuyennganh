package com.example.nguyenmanh.gogo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenmanh.gogo.Activity.PlayNhacActivity;
import com.example.nguyenmanh.gogo.Model.Baihat;
import com.example.nguyenmanh.gogo.R;
import com.example.nguyenmanh.gogo.Server.APIService;
import com.example.nguyenmanh.gogo.Server.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class seachbaihatadapter extends RecyclerView.Adapter<seachbaihatadapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihat;

    public seachbaihatadapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_seach_baihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenbaihat,txtcasi;
        ImageView imgbaihat,imgluotthich;
        public ViewHolder(View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewseachbaihat);
            txtcasi = itemView.findViewById(R.id.textviewseachcasi);
            imgbaihat = itemView.findViewById(R.id.imageseachbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewseachluotthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.Updateluotthich("1",mangbaihat.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")){
                                Toast.makeText(context,"Da thich", Toast.LENGTH_SHORT);
                            }else{
                                Toast.makeText(context,"da thich",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
