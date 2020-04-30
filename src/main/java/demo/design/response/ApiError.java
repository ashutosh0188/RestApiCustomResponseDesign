package demo.design.response;

import java.io.Serializable;

/**
 * This is an standard interface designed to facilitates
 * error encapsulation inside response, if any and
 * can be instantiated by using it's builder
 * implementation {@link ApiErrorBuilder}
 *
 * @author Ashutosh Srivastava
 * @since 16/04/2020
 */
public class ApiError implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private String details;

    /**
     * Instantiate error with code and message
     *
     * @param code    code
     * @param message message
     */
    ApiError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Instantiate error with code, message and details.
     *
     * @param code    code of error
     * @param message cause/reason of error
     * @param details details of error
     */
    ApiError(String code, String message, String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    /**
     * Get error code
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Get error message
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get error details
     * @return details
     */
    public String getDetails() {
        return details;
    }
}
