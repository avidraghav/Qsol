package com.application.kurukshetrauniversitypapers;

public class Videoinfo {
    String topic;
    String teacher;
    String duration;
    int image;


    public Videoinfo( String topic, String teacher,String duration,int image) {
        this.topic = topic;
        this.teacher = teacher;
        this.duration = duration;
        this.image=image;

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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
