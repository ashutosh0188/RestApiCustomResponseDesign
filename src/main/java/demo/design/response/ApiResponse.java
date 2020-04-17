package demo.design.response;

/**
 * This is an interface to declare standard methods for creating different types of responses
 * @param <T> generic type of entity/object
 *
 * @author Ashutosh Srivastava
 * @since 15/04/2020
 */
public interface ApiResponse<T> extends ApiError
{
	/**
	 * This is getter method which returns payload. This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 * @return T is an entity/object
	 */
	public T getPayload();

	/**
	 * This is getter method which returns status. This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 * @return status as string
	 */
	public String getStatus();

	/**
	 * This is getter method which returns message. This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 * @return message as string
	 */
	public String getMessage();

	/**
	 * This is getter method which code status. This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 * @return code as string
	 */
	public String getCode();

	/**
	 * This is getter method which returns current timestamp. This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 * @return datetime as currentTimeStamp of machine/server on which this code will be running.
	 */
	public long getDateTime();
}
