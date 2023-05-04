package com.example.rssdisplayer.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rssdisplayer.R;


public class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    ImageView imageViewThumbnail;
    TextView title, date, link, author, description;

    private ItemClickListener itemClickListener;

    public FeedViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewThumbnail = itemView.findViewById(R.id.imageview);
        title = itemView.findViewById(R.id.title);
        date = itemView.findViewById(R.id.date);
        link = itemView.findViewById(R.id.link);
        author = itemView.findViewById(R.id.author);
        description = itemView.findViewById(R.id.description);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
