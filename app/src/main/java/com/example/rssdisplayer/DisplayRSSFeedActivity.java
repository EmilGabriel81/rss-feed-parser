package com.example.rssdisplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.rssdisplayer.datahandler.HTTPDataHandler;
import com.example.rssdisplayer.model.RSSObject;
import com.example.rssdisplayer.recyclerview.FeedAdapter;
import com.google.gson.Gson;


public class DisplayRSSFeedActivity extends AppCompatActivity {

    private final String RSS_LINK = "https://agroromania.manager.ro/rss_stiri.php";
    private final String RSS_TO_JSON_API = " https://api.rss2json.com/v1/api.json?rss_url=";
    RecyclerView recyclerView;
    RSSObject rssObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rssfeed);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadRSS();
    }

    private void loadRSS() {
        AsyncTask<String, String, String> loadRSSAsync = new AsyncTask<String, String, String>() {
            ProgressDialog mDialog = new ProgressDialog(DisplayRSSFeedActivity.this);

            @Override
            protected void onPreExecute() {
                mDialog.setMessage("Please wait...........");
                mDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler httpDataHandler = new HTTPDataHandler();
                result = httpDataHandler.getHttpData(params[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                mDialog.dismiss();
                rssObject = new Gson().fromJson(s, RSSObject.class);
                Log.e("The feed from connection", rssObject.getItems().get(0).toString());
                // logic for the recyclerview
                FeedAdapter adapter = new FeedAdapter(rssObject, getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        StringBuilder urlGetdata = new StringBuilder(RSS_TO_JSON_API);
        urlGetdata.append(RSS_LINK);
        loadRSSAsync.execute(urlGetdata.toString());
    }
}