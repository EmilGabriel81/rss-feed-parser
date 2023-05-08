package com.example.rssdisplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.rssdisplayer.view.DisplayRSSFeedActivity;

public class MainActivity extends AppCompatActivity {


    /**
     * source from: https://agroromania.manager.ro/
     * https://agroromania.manager.ro/rss_stiri.php
     * down the bottom "Feed RSS"
     * inspriration from: https://www.youtube.com/watch?v=APInjVO0WkQ
     * from Rss to JSON: https://rss2json.com
     * Json converter to class model: https://json2csharp.com/
     *
     * 1. convert the xml feed to Json
     * 2. create the model classes
     * 3. generate Getters, Setters, constructors with all fields
     * 4. create the data handler class with the url connection method
     */


    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rssBtn = findViewById(R.id.button);
        rssBtn.setOnClickListener(e -> {
            startActivity(new Intent(MainActivity.this, DisplayRSSFeedActivity.class));
        });
    }


}