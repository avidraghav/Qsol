package com.application.kurukshetrauniversitypapers;

public class Videoinfo {
    String topic;
    String teacher;
    String duration;


    public Videoinfo( String topic, String teacher,String duration) {
        this.topic = topic;
        this.teacher = teacher;
        this.duration = duration;

    }
    public Videoinfo(){

    }


    public String getTopic() {

        return topic;

    }

    public String getTeacher() {
        return teacher;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

}
