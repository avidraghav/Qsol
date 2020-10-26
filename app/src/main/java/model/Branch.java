package model;

import java.util.List;

public class Branch {

    private String id;
    private List<Semester> semesters;
    private long papersCount;

    public Branch() {
    }

    public Branch(String id, List<Semester> semesters) {
        this.id = id;
        this.semesters = semesters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    public void addSemester(Semester semester) {
        this.semesters.add(semester);
    }

    public void removeSemester(Semester semester) {
        this.semesters.remove(semester);
    }

    public long getPapersCount() {
        // TODO Remove workaround when branches have papers count
        this.papersCount = 0;
        for (Semester s : semesters) {
            this.papersCount += s.getPapersCount();
        }
        return this.papersCount;
    }

    public void setPapersCount(long papersCount) {
        this.papersCount = papersCount;
    }
}
