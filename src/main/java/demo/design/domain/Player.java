package demo.design.domain;

public class Player
{
	private long id;
	private String name;

	public Player(){}

	public Player(long id, String name){
		this.id = id;
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Player{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
