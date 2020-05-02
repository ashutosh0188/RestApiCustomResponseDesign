package demo.design.response;

public class PagingApiResponseBuilder<T> extends ApiResponseBuilder {
    private final PagingApiResponse<T> pagingApiResponse;

    public PagingApiResponseBuilder() {
        this.pagingApiResponse = new PagingApiResponse<>();
    }

    public PagingApiResponseBuilder pageNo(int pageNo) {
        this.pagingApiResponse.setCurrentPageNo(pageNo);
        return this;
    }

    public PagingApiResponseBuilder results(long results) {
        this.pagingApiResponse.setResultsPerPage(results);
        return this;
    }

    public PagingApiResponse<T> build() {
        ApiResponse<T> apiResponse = super.build();
        pagingApiResponse.setDateTime(apiResponse.getDateTime());
        pagingApiResponse.setStatus(apiResponse.getStatus());
        pagingApiResponse.setCode(apiResponse.getCode());
        pagingApiResponse.setMessage(apiResponse.getMessage());
        pagingApiResponse.setPayload(apiResponse.getPayload());
        pagingApiResponse.setApiError(apiResponse.getApiError());
        return pagingApiResponse;
    }
}
