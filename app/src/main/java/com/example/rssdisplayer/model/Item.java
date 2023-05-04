package com.example.rssdisplayer.model;

import java.util.ArrayList;

public class Item {
    public String title;
    public Object pubDate;
    public String link;
    public String guid;
    public String author;
    public String thumbnail;
    public String description;
    public String content;
    public Enclosure enclosure;
    public ArrayList<Object> categories;

    public Item(String title, Object pubDate, String link, String guid, String author, String thumbnail, String description, String content, Enclosure enclosure, ArrayList<Object> categories) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
        this.author = author;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.enclosure = enclosure;
        this.categories = categories;
    }

    // Getters and Setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getPubDate() {
        return pubDate;
    }

    public void setPubDate(Object pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public ArrayList<Object> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Object> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", pubDate=" + pubDate +
                ", link='" + link + '\'' +
                ", guid='" + guid + '\'' +
                ", author='" + author + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", enclosure=" + enclosure +
                ", categories=" + categories +
                '}';
    }
}