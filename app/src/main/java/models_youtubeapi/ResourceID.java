package models_youtubeapi;

public class ResourceID {
    private String videoId;


    public ResourceID() {

    }
    public ResourceID(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}

