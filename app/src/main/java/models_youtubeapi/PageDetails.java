package models_youtubeapi;

public class PageDetails {
    private float totalResults;
    private float resultsPerPage;

    public PageDetails() {
    }

    public PageDetails(float totalResults, float resultsPerPage) {
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;
    }

    public float getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(float totalResults) {
        this.totalResults = totalResults;
    }

    public float getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(float resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
