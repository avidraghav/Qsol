package utils;

public class DatesheetsInfo {
    private String name;
    private String id;
    private String url;
    private String directory;
    public DatesheetsInfo() {
    }
    public DatesheetsInfo(String name, String id,String url,String directory) {
        this.name = name;
        this.id = id;
        this.url = url;
        this.directory=directory;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}