package models_youtubeapi;

public class VideoYT {
    private String id;
    private SnippetYT snippet;

    public VideoYT() {
    }

    public VideoYT(String id, SnippetYT snippet) {
        this.id = id;
        this.snippet = snippet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SnippetYT getSnippet() {
        return snippet;
    }

    public void setSnippet(SnippetYT snippet) {
        this.snippet = snippet;
    }
}
