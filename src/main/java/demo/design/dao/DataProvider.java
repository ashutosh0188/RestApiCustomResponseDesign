package demo.design.dao;

import demo.design.domain.Player;

import java.util.ArrayList;
import java.util.List;

class DataProvider
{
	private static final List<Player> players = new ArrayList<Player>();

	static {
		players.add(new Player(1, "Sourav Ganguly"));
		players.add(new Player(2, "Sachin Tendulkar"));
		players.add(new Player(3, "Virendra Shewag"));
		players.add(new Player(4, "Rohit Sharma"));
		players.add(new Player(5, "MS Dhoni"));
		players.add(new Player(6, "Virat Kohli"));
		players.add(new Player(7, "Hardik Pandey"));
		players.add(new Player(8, "Yuraj Singh"));
		players.add(new Player(9, "Gautam Gambhir"));
		players.add(new Player(10, "Suresh Raina"));
		players.add(new Player(11, "Zaheer Khan"));
	}
	private DataProvider(){}

	static List<Player> getPlayers()
	{
		return players;
	}

	static int getPlayerSize()
	{
		return players.size();
	}
}
