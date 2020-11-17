package utils;

public class uploadPDF {
    public String name;
    public  String url;
    public String solution_url;

    public uploadPDF() {
    }

    public uploadPDF(String name, String url, String solution_url) {
        this.name = name;
        this.url = url;
        this.solution_url=solution_url;
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

    public String getSolution_url() {
        return solution_url;
    }

    public void setSolution_url(String solution_url) {
        this.solution_url = solution_url;
    }
}
