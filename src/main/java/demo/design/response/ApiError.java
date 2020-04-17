package demo.design.response;

/**
 * This is an standard interface designed to facilitates
 * error encapsulation inside response, if any.
 *
 * @author Ashutosh Srivastava
 * @since 16/04/2020
 */
public interface ApiError
{
	/**
	 * Instantiate error with code and message
	 * @param code code
	 * @param message message
	 */
	public void setError(String code, String message);

	/**
	 * Instantiate error with code, message and details.
	 * @param code code of error
	 * @param message cause/reason of error
	 * @param details details of error
	 */
	public void setErrorWithDetails(String code, String message, String details);
}
