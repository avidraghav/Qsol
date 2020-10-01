package com.application.kurukshetrauniversitypapers;

import java.util.List;

public class Apimodel {
private String nextPageToken;
private List<VideoYT> items;

    public Apimodel() {
    }

    public Apimodel(String nextPageToken, List<VideoYT> items) {
        this.nextPageToken = nextPageToken;
        this.items = items;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<VideoYT> getItems() {
        return items;
    }

    public void setItems(List<VideoYT> items) {
        this.items = items;
    }
}
