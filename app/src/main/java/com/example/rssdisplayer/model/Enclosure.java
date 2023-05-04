package com.example.rssdisplayer.model;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
   Root root = om.readValue(myJsonString, Root.class); */
public class Enclosure {
    public String link;
    public String type;
    public int length;

    public Enclosure(String link, String type, int length) {
        this.link = link;
        this.type = type;
        this.length = length;
    }

    // Getters and Setters


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
