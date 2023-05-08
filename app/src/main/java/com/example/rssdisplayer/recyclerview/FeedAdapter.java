package com.example.rssdisplayer.recyclerview;

import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rssdisplayer.MainActivity;
import com.example.rssdisplayer.R;
import com.example.rssdisplayer.model.RSSObject;
import com.example.rssdisplayer.view.DisplayInfoActivity;

import java.util.Optional;

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private Context context;
    private RSSObject rssObject;
    private LayoutInflater inflater;


    public FeedAdapter(RSSObject rssObject, Context context) {
        this.context = context;
        this.rssObject = rssObject;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_view, parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

        String photoUrl = rssObject.getItems().get(position).getEnclosure().getLink().toString();
        Glide.with(context).load(photoUrl).into(holder.imageViewThumbnail);

        Optional<String> titleOptional = Optional.ofNullable(rssObject.getItems().get(position).getTitle().toString());
        //Optional<String> dateOptional = Optional.of(rssObject.getItems().get(position).getPubDate().toString());
        Optional<String> authorOptional = Optional.ofNullable(rssObject.getItems().get(position).getAuthor().toString());
        Optional<String> linkOptional = Optional.ofNullable(rssObject.getItems().get(position).getLink().toString());
        Optional<String> descriptionOptional = Optional.ofNullable(rssObject.getItems().get(position).getDescription().toString());
        Log.e("The thumbnail is:", "" + rssObject.getItems().get(position).getThumbnail());
        //holder.imageViewThumbnail.setImageIcon(null);
        if (titleOptional.isPresent()) holder.title.setText(titleOptional.get());
        // if (dateOptional.isPresent()) holder.date.setText(dateOptional.get()); <pubDate>Thu, 01 Jan 1970 00:00:00 UTC</pubDate>
        if (authorOptional.isPresent()) holder.author.setText(authorOptional.get());
        if (linkOptional.isPresent()) {
            holder.link.setText(linkOptional.get());
            holder.link.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                   Toast.makeText(context, "url: "+photoUrl, Toast.LENGTH_SHORT).show();
//                    String url = linkOptional.get();
//                    Intent intent = new Intent(context, Uri.parse(url));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
                }
            });
        }

        holder.imageViewThumbnail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayInfoActivity.class);
                intent.putExtra("photo", photoUrl);
                intent.putExtra("title", titleOptional.get());
                intent.putExtra("author", authorOptional.get());
                intent.putExtra("link", linkOptional.get());
                intent.putExtra("description", descriptionOptional.get());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    if (!isLongClick) {
                        Toast.makeText(context, "The item " + position + " was pressed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }

    @Override
    public int getItemCount() {
        return rssObject.getItems().size();
    }

}
