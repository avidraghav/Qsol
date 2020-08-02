package com.application.kurukshetrauniversitypapers;

public class Listdata {
    String subjectname;
    String papercount;


    public Listdata( String subjectname, String papercount) {
        this.subjectname = subjectname;
        this.papercount = papercount;

    }
    public Listdata(){

    }


    public String getSubjectname() {

            return subjectname;

    }

    public String getPapercount() {
        return "("+papercount+")";
    }

}
