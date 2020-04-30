package demo.design.response;

/**
 * This is a Fluent Builder class for instantiating {@link ApiError} object which
 * actually encapsulated by {@link ApiResponse} object
 *
 * @author Ashutosh Srivastava
 * @since 01/05/2020
 */
public final class ApiErrorBuilder {
    private String code;
    private String message;
    private String details;

    /**
     * Parametrized constructor with a required field to instantiate
     * error object with this param
     * Setting message to the error object
     * @param message message
     */
    public ApiErrorBuilder(String message) {
        this.message = message;
    }

    /**
     * Setting code to the error object
     * @param code code
     * @return Instance of this class
     */
    public ApiErrorBuilder errorCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Setting details to the error object
     * @param details details
     * @return Instance of this class
     */
    public ApiErrorBuilder errorDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * Building and returning the actual response object
     * @return ApiError instance
     */
    public ApiError build() {
        return new ApiError(code, message, details);
    }
}
