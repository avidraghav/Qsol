package utils;

public class DatesheetsInfo {
    private String name;
    private String id;

    public DatesheetsInfo() {
    }
    public DatesheetsInfo(String name, String id) {
        this.name = name;
        this.id = id;
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
}