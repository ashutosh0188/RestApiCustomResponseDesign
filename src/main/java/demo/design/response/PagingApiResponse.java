package demo.design.response;

public class PagingApiResponse<T> extends ApiResponse<T> {
    private int currentPageNo;
    private long resultsPerPage;

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public long getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(long resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
