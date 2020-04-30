package demo.design.response;

import java.util.Calendar;

/**
 * An abstract class which encapsulate different types of
 * basic elements of a response object.
 *
 * @author Ashutosh Srivastava
 * @since 01/05/2020
 */
abstract class AbstractApiResponse {
    private long dateTime;
    private String status;
    private String code;
    private String message;

    /**
     * Get current date time stamp of server/machine in milliseconds
     * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
     *
     * @return milliseconds
     */
    public long getDateTime() {
        return dateTime;
    }

    /**
     * It may be as SUCCESS/FAILURE. This may be used by any object
     * mapper like jackson or ObjectMapper third party libraries.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get code. This may be standard HttpStatus codes i.e. 1XX, 2XX, 5XX etc.
     * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Get message/details about api operation response like user created successfully.
     * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set response status
     * @param status status
     */
    void setStatus(String status) {
        this.status = status;
    }

    /**
     * Set response code
     * @param code code
     */
    void setCode(String code) {
        this.code = code;
    }

    /**
     * Set response message
     * @param message message
     */
    void setMessage(String message) {
        this.message = message;
    }
}
