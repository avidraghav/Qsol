package models_youtubeapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Apimodel {

    @SerializedName("nextPageToken")
    private String nextPageToken;
private List<VideoYT> items;
private PageDetails pageInfo;

    public Apimodel() {
    }

    public Apimodel(String nextPageToken, List<VideoYT> items, PageDetails pageInfo)
    {
        this.nextPageToken = nextPageToken;
        this.items = items;
        this.pageInfo = pageInfo;
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

    public PageDetails getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageDetails pageInfo) {
        this.pageInfo = pageInfo;
    }
}
