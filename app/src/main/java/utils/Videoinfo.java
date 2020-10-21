package utils;

public class Videoinfo {
    private String subjectname;
    private String channelname;
    private String playlistid;
    private String imageurl;

    public Videoinfo() {

    }

    public Videoinfo(String subjectname, String channelname, String imageurl,String playlistid) {
        this.subjectname = subjectname;
        this.channelname = channelname;
        this.imageurl = imageurl;
        this.playlistid=playlistid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(String playlistid) {
        this.playlistid = playlistid;
    }
}
