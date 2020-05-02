package demo.design.service;

import demo.design.dao.PlayerDao;
import demo.design.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService
{
	@Autowired
	private PlayerDao playerDao;

	public Player addPlayer(Player p)
	{
		return playerDao.addPlayer(p);
	}

	public Player getPlayer(long id)
	{
		return playerDao.fetchPlayer(id);
	}

	public List<Player> getAllPlayer()
	{
		return playerDao.fetchAllPlayer();
	}

	public List<Player> getPlayer(int pageNo, int resultsPerPage) {
		return playerDao.fetchAllPlayer(pageNo, resultsPerPage);
	}

	public Player updatePlayer(long id, String name)
	{
		if(playerDao.updateName(id, name)>0)
		{
			return playerDao.fetchPlayer(id);
		}
		return null;
	}

	public int deletePlayer(long id)
	{
		return playerDao.deletePlayer(id);
	}
}
