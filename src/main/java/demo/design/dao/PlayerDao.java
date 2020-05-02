package demo.design.dao;

import demo.design.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Repository
public class PlayerDao
{
	public Player addPlayer(Player p)
	{
		p.setId(DataProvider.getPlayerSize()+1);
		DataProvider.getPlayers().add(p);
		return p;
	}

	public Player fetchPlayer(long id)
	{
		List<Player> players = DataProvider.getPlayers();
		for(Player p : players)
		{
			if(p.getId()==id) return p;
		}
		return null;
	}

	public List<Player> fetchAllPlayer()
	{
		return DataProvider.getPlayers();
	}

	public List<Player> fetchAllPlayer(int page, int pageSize)
	{
		if(page <= 0) {
			throw new IllegalArgumentException("invalid page no: " + page);
		}
		if(pageSize <= 0) {
			throw new IllegalArgumentException("invalid results per page: " + pageSize);
		}
		List<Player> sourceList = DataProvider.getPlayers();

		int fromIndex = (page - 1) * pageSize;
		if(sourceList.size() < fromIndex){
			return Collections.emptyList();
		}

		// toIndex exclusive
		return sourceList.subList(fromIndex, Math.min(fromIndex + pageSize, sourceList.size()));
	}

	public long updateName(long id, String name)
	{
		Iterator<Player> iterator = DataProvider.getPlayers().iterator();
		while(iterator.hasNext())
		{
			Player p = iterator.next();
			if(p.getId()==id)
			{
				p.setName(name);
				return p.getId();
			}
		}
		return -1;
	}

	public int deletePlayer(long id)
	{
		Iterator<Player> iterator = DataProvider.getPlayers().iterator();
		while(iterator.hasNext())
		{
			Player p = iterator.next();
			if(p.getId()==id)
			{
				iterator.remove();
				return 1;
			}
		}
		return -1;
	}
}
