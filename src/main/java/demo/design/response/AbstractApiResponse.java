package demo.design.response;

import java.util.Calendar;

/**
 * This is an abstract class which is defines different properties of {@link ApiResponse}
 *
 * @param <T> generic type of entity/object
 * @author Ashutosh Srivastava
 * @since 15/04/2020
 */
public abstract class AbstractApiResponse<T> implements ApiResponse<T>
{
	private long dateTime;

	private String message;

	private String status;

	private String code;

	private T payload;

	private Error error;

	/**
	 * Parametrized constructor to initialize properties defined by this class.
	 *
	 * @param status  status i.e. may be termed as SUCCESS/FAILURE
	 * @param message message i.e. may be any valid message that needs to return to user for better understanding
	 * @param code    code i.e. may be http status or user defined code
	 */
	AbstractApiResponse(String status, String message, String code)
	{
		this(status, message, code, null);
	}

	/**
	 * Parametrized constructor to initialize properties defined by this class.
	 *
	 * @param status  status i.e. may be termed as SUCCESS/FAILURE
	 * @param message message i.e. may be any valid message that needs to return to user for better understanding
	 * @param code    code i.e. may be http status or user defined code
	 * @param payload data i.e. is payload as an object/entity
	 */
	AbstractApiResponse(String status, String message, String code, T payload)
	{
		this.message = message;
		this.status = status;
		this.code = code;
		this.dateTime = Calendar.getInstance().getTimeInMillis();
		this.payload = payload;
	}

	/**
	 * This is getter method which returns payload. This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return Generic type entity/Object
	 */
	public T getPayload()
	{
		return payload;
	}

	/**
	 * It may be as SUCCESS/FAILURE. This may be used by any object
	 * mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Get message/details about api operation response like user created successfully.
	 * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return message
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Get code. This may be standard HttpStatus codes i.e. 1XX, 2XX, 5XX etc.
	 * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Get current date time stamp of server/machine in milliseconds
	 * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return milliseconds
	 */
	public long getDateTime()
	{
		return dateTime;
	}

	/**
	 * Get error object. This return the {@link Error} object.
	 * This may be used by any object mapper like jackson or ObjectMapper third party libraries.
	 *
	 * @return {@link Error}
	 */
	public Error getError()
	{
		return error;
	}

	/**
	 * This method sets {@link Error} object
	 *
	 * @param code    code
	 * @param message message
	 */
	@Override public void setError(String code, String message)
	{
		this.setErrorWithDetails(code, message, null);
	}

	/**
	 * This method sets {@link Error} object
	 *
	 * @param code    error code
	 * @param message cause of error
	 * @param details details of error
	 */
	@Override public void setErrorWithDetails(String code, String message, String details)
	{
		error = new Error(code, message, details);
	}

	/**
	 * This is an static nested class to instantiate error object, while returning
	 * in {@link ApiResponse} if any error occurred.
	 *
	 * @author Ashutosh Srivastava
	 * @since 16/04/2020
	 */
	private static final class Error
	{
		private String code;

		private String message;

		private String details;

		/**
		 * Constructor to instantiate this class object
		 *
		 * @param code    error code
		 * @param message error cause
		 * @param details error details
		 */
		Error(String code, String message, String details)
		{
			this.code = code;
			this.message = message;
			this.details = details;
		}

		/**
		 * Get error code
		 *
		 * @return error code
		 */
		public String getCode()
		{
			return code;
		}

		/**
		 * Get error message/cause
		 *
		 * @return error message
		 */
		public String getMessage()
		{
			return message;
		}

		/**
		 * Get error details
		 *
		 * @return error details
		 */
		public String getDetails()
		{
			return details;
		}
	}
}
