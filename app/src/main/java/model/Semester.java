package model;

import java.util.List;

public class Semester {

    private String id;
    private List<Lecture> lectures;
    private long papersCount;

    public Semester() {
    }

    public Semester(String id, List<Lecture> lectures) {
        this.id = id;
        this.lectures = lectures;
    }

    public Semester(String id, List<Lecture> lectures, long papersCount) {
        this.id = id;
        this.lectures = lectures;
        this.papersCount = papersCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public void removeLecture(Lecture lecture) {
        this.lectures.remove(lecture);
    }

    public long getPapersCount() {
        return papersCount;
    }

    public void setPapersCount(long papersCount) {
        this.papersCount = papersCount;
    }
}
