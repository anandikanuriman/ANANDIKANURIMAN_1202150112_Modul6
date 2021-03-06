package com.example.anandika.anandikanuriman_1202150112_modul6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Anandika on 01/04/2018.
 */

public class adapterpost extends RecyclerView.Adapter<adapterpost.PostViewHolder> {
    private List<databasepost> list;
    private Context con;

    public adapterpost(List<databasepost> list, Context con){
        this.list = list;
        this.con = con;
    }
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(con).inflate(R.layout.cv_feed, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        databasepost current = list.get(position);
        String [] user = current.user.split("@");
        holder.user.setText(user[0]);
        holder.user.setTag(current.getKey());
        holder.judul.setText(current.getJudul());
        holder.caption.setText(current.getCaption());
        holder.caption.setTag(current.getImage());
        Glide.with(con).load(current.getImage()).placeholder(R.drawable.uploadfoto).override(450, 450).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView user, judul, caption;

        public PostViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.postgambarnya);
            user = itemView.findViewById(R.id.postpengupload);
            judul = itemView.findViewById(R.id.postjudul);
            caption = itemView.findViewById(R.id.postdeskripsi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pindah = new Intent(con, Post.class);
                    pindah.putExtra("user", user.getText());
                    pindah.putExtra("key", user.getTag().toString());
                    pindah.putExtra("judul", judul.getText());
                    pindah.putExtra("caption", caption.getText());
                    pindah.putExtra("image", caption.getTag().toString());
                    con.startActivity(pindah);
                }
            });

        }
    }
        }
