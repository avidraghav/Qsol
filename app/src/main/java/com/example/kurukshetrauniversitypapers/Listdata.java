package com.example.kurukshetrauniversitypapers;

public class Listdata {
    String subjectname;
    int papercount;


    public Listdata( String subjectname, int papercount) {
        this.subjectname = subjectname;
        this.papercount = papercount;

    }
    public Listdata(){

    }


    public String getSubjectname() {
        return subjectname;
    }

    public int getPapercount() {
        return papercount;
    }

}
