package com.example.rssdisplayer.model;

import java.util.ArrayList;


public class RSSObject {
        // ex RootObject
        public String status;
        public Feed feed;
        public ArrayList<Item> items;

        public RSSObject(String status, Feed feed, ArrayList<Item> items) {
            this.status = status;
            this.feed = feed;
            this.items = items;
        }

        // Getters and Setters

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Feed getFeed() {
            return feed;
        }

        public void setFeed(Feed feed) {
            this.feed = feed;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }
    }


