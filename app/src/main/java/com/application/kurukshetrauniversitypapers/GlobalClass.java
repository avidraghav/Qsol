package com.application.kurukshetrauniversitypapers;

import android.app.Application;

public class GlobalClass extends Application {
   static String branch;

    static int semester;



    public String getBranch() {
        return branch;
    }



    public int getSemester() {
        return semester;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }



    public void setSemester(int semester) {
        this.semester = semester;
    }
}
