package model;

public class Lecture {

    private String id;
    private String name;
    private long papersCount;

    public Lecture() {
    }

    public Lecture(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Lecture(String id, String name, long papersCount) {
        this.id = id;
        this.name = name;
        this.papersCount = papersCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPapersCount() {
        return papersCount;
    }

    public void setPapersCount(long papersCount) {
        this.papersCount = papersCount;
    }
}
