package com.example.nguyenmanh.gogo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenmanh.gogo.Activity.DanhsachbaihatActivity;
import com.example.nguyenmanh.gogo.Model.Album;
import com.example.nguyenmanh.gogo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ALLAlbumAdapter extends RecyclerView.Adapter<ALLAlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> albumArrayList;

    public ALLAlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album album = albumArrayList.get(position);
        Picasso.with(context).load(album.getHinhanhAlbum()).into(holder.imgallalbum);
        holder.txttenallalbum.setText(album.getTenAlbum());

    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgallalbum;
        TextView txttenallalbum;
        public ViewHolder(View itemView) {
            super(itemView);
            imgallalbum = itemView.findViewById(R.id.imagaviewalbum);
            txttenallalbum = itemView.findViewById(R.id.textviewallalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album",albumArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }

}
