package demo.design.response;


public class PlayerResponse<T> extends AbstractApiResponse<T>
{
	public PlayerResponse(String status, String code, T data)
	{
		this(status, null, code, data);
	}

	public PlayerResponse(String status, String code, String message)
	{
		this(status, message, code, null);
	}

	public PlayerResponse(String status, String message, String code, T data)
	{
		super(status, message, code, data);
	}
}
