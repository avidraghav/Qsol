package utils;

public class NotificationGetter {
    private String text;
    private String url;

    public NotificationGetter(){}
    public NotificationGetter(String text,String url){
        this.text=text;
        this.url=url;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
