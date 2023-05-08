package com.example.rssdisplayer.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rssdisplayer.R;

public class DisplayInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disply_info);

        ImageView photoImageView = findViewById(R.id.image_info);
        TextView titleTextView = findViewById(R.id.title_info);
        TextView authorTextView = findViewById(R.id.author_info);
        TextView descriptionTextView = findViewById(R.id.description_info);
        descriptionTextView.setMovementMethod(new ScrollingMovementMethod());
        TextView linkTextView = findViewById(R.id.link_info);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String photoUrl = extras.getString("photo");
            String title = extras.getString("title");
            String author = extras.getString("author");
            String link = extras.getString("link");
            String description = extras.getString("description");

            Glide.with(this).load(photoUrl).into(photoImageView);

            titleTextView.setText(title);
            authorTextView.setText(author);
            descriptionTextView.setText(description);
            linkTextView.setText(link);
        }
    }
}