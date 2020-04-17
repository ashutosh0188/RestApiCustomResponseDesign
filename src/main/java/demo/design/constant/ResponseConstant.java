package demo.design.constant;

public enum ResponseConstant
{
	SUCCESS(200), FAILURE(400), INTERNAL_SERVER_ERROR(500), UNDER_MAINTENANCE(503);

	private int code;

	ResponseConstant(int i)
	{
		this.code = i;
	}

	public String code()
	{
		return Integer.toString(code);
	}

	public static ResponseConstant fromValue(int val)
	{
		for(ResponseConstant r : ResponseConstant.values())
		{
			if(val == r.code)
			{
				return r;
			}
		}
		throw new IllegalArgumentException("Illegal enum constant "+val);
	}
}
