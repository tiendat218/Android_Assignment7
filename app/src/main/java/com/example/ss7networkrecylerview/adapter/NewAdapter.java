package com.example.ss7networkrecylerview.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ss7networkrecylerview.R;
import com.example.ss7networkrecylerview.model.Item;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter {
    private List<Item> list;
    private Activity activity;

    public NewAdapter(List<Item> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    public void reloadData(List<Item> listData) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_news,parent,false);
        NewsHolder holder = new NewsHolder(itemView);

        return holder;
    }

    @Override
    public void  onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,int position){
        NewsHolder hd = (NewsHolder) holder;
        Item model = list.get(position);
        hd.tvDate.setText(model.getDate());
        hd.tvTitle.setText(model.getTitle());
        hd.tvContent.setText(model.getContent().getDescription());
        Glide.with(activity).load(model.getImage()).into(hd.ivCover);

    }
    @Override
    public int getItemCount(){
        return list.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        TextView tvDate,tvTitle,tvContent;
        ImageView ivCover;

        public NewsHolder(@NonNull View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}
