package demo.design.response;

import java.io.Serializable;

/**
 * This class wraps response of any endpoints defined by it's using Api
 * and can be instantiated by using it's builder implementation
 * {@link ApiResponseBuilder} with all it's properties
 *
 * @param <T> generic type of entity/object
 * @author Ashutosh Srivastava
 * @since 15/04/2020
 */
public class ApiResponse<T> extends AbstractApiResponse implements Serializable
{
	private static final long serialVersionUID = 1L;

	private T payload;
	private ApiError error;

	/**
	 * This is getter method which returns payload. This may be used
	 * by any object mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return Generic type entity/Object
	 */
	public T getPayload()
	{
		return payload;
	}

	/**
	 * Set payload data
	 * @param payload payload
	 */
	void setPayload(T payload) {
		this.payload = payload;
	}

	/**
	 * Get ApiError object
	 * @return ApiError
	 */
	public ApiError getApiError() {
		return error;
	}

	/**
	 * Set apiError object
	 * @param error object
	 */
	void setApiError(ApiError error) {
		this.error = error;
	}
}
