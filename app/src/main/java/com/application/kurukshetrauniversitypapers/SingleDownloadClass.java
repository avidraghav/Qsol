package com.application.kurukshetrauniversitypapers;

import android.app.Application;

public class SingleDownloadClass extends Application {
    static String branch;
    static String semester;
    static String code;

    public String getBranch() {
        return branch;
    }
    public String getSemester() {
        return semester;
    }
    public String getCode(){return code;}
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public void setCode(String code){this.code=code;}
}
