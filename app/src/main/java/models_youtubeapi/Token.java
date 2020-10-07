package models_youtubeapi;

public class Token {
    private String nextPageToken;

    public Token() {
    }

    public Token(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

}
