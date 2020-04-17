package demo.design.controller;

import demo.design.constant.ResponseConstant;
import demo.design.domain.Player;
import demo.design.response.ApiResponse;
import demo.design.response.PlayerResponse;
import demo.design.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerEndpoint
{
	@Autowired
	private PlayerService playerService;

	@GetMapping("/")
	public String testApi()
	{
		return "It's working.\nThank you. :)";
	}

	@PostMapping("/create")
	public ApiResponse<Player> addPlayer(@RequestBody Player player)
	{
		if(player!=null && player.getName()!=null)
		{
			player = playerService.addPlayer(player);
			return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), "Player created successfully", ResponseConstant.fromValue(200).code(), player);
		}
		return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), "Player could not be created. Name is missing");
	}

	@GetMapping("/{id}")
	public ApiResponse<Player> getPlayer(@PathVariable("id") long id)
	{
		Player p = playerService.getPlayer(id);
		return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), p);
	}

	@GetMapping("/all")
	public ApiResponse<List<Player>> getAllPlayer()
	{
		List<Player> players = playerService.getAllPlayer();
		return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), players);
	}

	@GetMapping("/update/{id}/{name}")
	public ApiResponse<Player> updatePlayer(@PathVariable ("id") long id, @PathVariable("name") String name)
	{
		Player p = playerService.updatePlayer(id, name);
		if(p!=null)
		{
			return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), "Player updated successfully with id "+id, p);
		}
		return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), "Player does not exist with given id "+id);
	}

	@GetMapping("/delete/{id}")
	public ApiResponse<Player> deletePlayer(@PathVariable("id") long id)
	{
		int status = playerService.deletePlayer(id);
		if(status>0)
		{
			return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), "Player removed successfully with id "+id);
		}
		return new PlayerResponse<>(ResponseConstant.SUCCESS.name(), ResponseConstant.fromValue(200).code(), "Player does not exist with given id"+id);
	}

	@GetMapping("/error")
	public ApiResponse<Long> testError()
	{
		ApiResponse<Long> apiResponse = new PlayerResponse<>(ResponseConstant.FAILURE.name(), null, null, null);
		try
		{
			int a = 5/0;
		}catch(Exception e)
		{
			apiResponse.setErrorWithDetails(ResponseConstant.INTERNAL_SERVER_ERROR.code(), "Error occurred during division", e.getMessage());
			return apiResponse;
		}
		return apiResponse;
	}
}
