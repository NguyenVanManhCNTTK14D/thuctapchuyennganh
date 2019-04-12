package com.example.nguyenmanh.gogo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenmanh.gogo.Model.Album;
import com.example.nguyenmanh.gogo.Model.Theloai;
import com.example.nguyenmanh.gogo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class theloaiAdapter extends RecyclerView.Adapter<theloaiAdapter.ViewHoder>{

    Context context;
    ArrayList<Theloai>mangtheloai;

    public theloaiAdapter(Context context, ArrayList<Theloai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_theloai,parent,false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        Theloai theloai = mangtheloai.get(position);
        holder.txttentheloai.setText(theloai.getTenTheLoai());
        Picasso.with(context).load(theloai.getHinhTheLoai()).into(holder.imghinhtheloai);

    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        ImageView imghinhtheloai;
        TextView txttentheloai;
        public ViewHoder(View itemView) {
            super(itemView);
            imghinhtheloai = itemView.findViewById(R.id.imageviewtheloai);
            txttentheloai = itemView.findViewById(R.id.textviewtentheloai);
        }

    }
}
