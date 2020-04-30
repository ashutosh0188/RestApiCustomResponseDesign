package demo.design.response;

/**
 * This is a Fluent Builder class for instantiating {@link ApiResponse} object.
 * @param <T> generic type of payload data
 *
 * @author Ashutosh Srivastava
 * @since 01/05/2020
 */
public class ApiResponseBuilder<T> {
    /**
     * Immutable object of ApiResponse
     */
    private final ApiResponse<T> apiResponse = new ApiResponse<>();

    /**
     * Parametrized constructor with a required field to instantiate
     * response object with this param
     * Setting status to the response object
     * @param status status
     */
    public ApiResponseBuilder(String status) {
        this.apiResponse.setStatus(status);
    }

    /**
     * Setting code to the response object
     * @param code code
     * @return Instance of this class
     */
    public ApiResponseBuilder<T> code(String code) {
        this.apiResponse.setCode(code);
        return this;
    }

    /**
     * Setting message to the response object
     * @param message message
     * @return Instance of this class
     */
    public ApiResponseBuilder<T> message(String message) {
        this.apiResponse.setMessage(message);
        return this;
    }

    /**
     * Setting payload to the response object
     * @param payload actual data to be send back
     * @return Instance of this class
     */
    public ApiResponseBuilder<T> payload(T payload) {
        this.apiResponse.setPayload(payload);
        return this;
    }

    /**
     * Setting apiError to the response object
     * @param apiError any error occurred during serving any request
     * @return Instance of this class
     */
    public ApiResponseBuilder<T> error(ApiError apiError) {
        this.apiResponse.setApiError(apiError);
        return this;
    }

    /**
     * Building and returning the actual response object
     * @return ApiResponse instance
     */
    public ApiResponse<T> build() {
        return apiResponse;
    }
}
