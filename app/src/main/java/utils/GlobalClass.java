package utils;

import android.app.Application;

public class GlobalClass extends Application {
    static String board;
    static String branch;
    static String semester;
    static String videoId;
    static Float totalresults;

    public Float getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(Float totalresults) {
        this.totalresults = totalresults;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getBranch() {
        return branch;
    }

    public String getBoard() {
        return board;
    }
    public void setBoard(String board) {
        this.board = board;
    }
    public String getSemester() {
        return semester;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
