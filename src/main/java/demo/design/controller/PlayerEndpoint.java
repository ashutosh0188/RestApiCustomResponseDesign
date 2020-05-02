package demo.design.controller;

import demo.design.constant.ResponseConstant;
import demo.design.domain.Player;
import demo.design.response.*;
import demo.design.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
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
			return new ApiResponseBuilder<Player>()
					.status(ResponseConstant.SUCCESS.name())
					.code(ResponseConstant.SUCCESS.code())
					.message("Player created successfully")
					.payload(player)
					.build();
		}
		return new ApiResponseBuilder<Player>()
				.status(ResponseConstant.SUCCESS.name())
				.code(ResponseConstant.SUCCESS.code())
				.message("Player could not be created. Name is missing")
				.payload(player)
				.build();
	}

	@GetMapping("/{id}")
	public ApiResponse<Player> getPlayer(@PathVariable("id") long id)
	{
		Player p = playerService.getPlayer(id);
		return new ApiResponseBuilder<Player>()
				.dateTime(Calendar.getInstance().getTimeInMillis())
				.status(ResponseConstant.SUCCESS.name())
				.code(ResponseConstant.SUCCESS.code())
				.payload(p)
				.build();
	}

	@GetMapping("/all")
	public ApiResponse<List<Player>> getAllPlayer()
	{
		List<Player> players = playerService.getAllPlayer();
		return new ApiResponseBuilder<List<Player>>()
				.dateTime(Calendar.getInstance().getTimeInMillis())
				.status(ResponseConstant.SUCCESS.name())
				.code(ResponseConstant.SUCCESS.code())
				.dateTime(Calendar.getInstance().getTimeInMillis())
				.payload(players)
				.build();
	}

	@GetMapping("/update/{id}/{name}")
	public ApiResponse<Player> updatePlayer(@PathVariable ("id") long id, @PathVariable("name") String name)
	{
		Player p = playerService.updatePlayer(id, name);
		if(p!=null)
		{
			return new ApiResponseBuilder<Player>()
					.dateTime(Calendar.getInstance().getTimeInMillis())
					.status(ResponseConstant.SUCCESS.name())
					.code(ResponseConstant.SUCCESS.code())
					.message("Player updated successfully with id "+id)
					.payload(p)
					.build();
		}
		return new ApiResponseBuilder<Player>()
				.status(ResponseConstant.SUCCESS.name())
				.code(ResponseConstant.SUCCESS.code())
				.message("Player does not exist with given id "+id)
				.build();
	}

	@GetMapping("/delete/{id}")
	public ApiResponse<Player> deletePlayer(@PathVariable("id") long id)
	{
		int status = playerService.deletePlayer(id);
		if(status>0)
		{
			return new ApiResponseBuilder<Player>()
					.dateTime(Calendar.getInstance().getTimeInMillis())
					.status(ResponseConstant.SUCCESS.name())
					.code(ResponseConstant.SUCCESS.code())
					.message("Player removed successfully with id "+id)
					.build();
		}
		return new ApiResponseBuilder<Player>()
				.dateTime(Calendar.getInstance().getTimeInMillis())
				.status(ResponseConstant.SUCCESS.name())
				.code(ResponseConstant.SUCCESS.code())
				.message("Player does not exist with given id"+id)
				.build();
	}

	@GetMapping("/error")
	public ApiResponse<Player> testError()
	{
		try
		{
			int a = 5/0;
		}catch(Exception e)
		{
			ApiError apiError = new ApiErrorBuilder("Error occurred during division")
					.errorCode(ResponseConstant.INTERNAL_SERVER_ERROR.code())
					.errorDetails(e.getMessage())
					.build();
			return new ApiResponseBuilder<Player>()
					.status(ResponseConstant.FAILURE.name())
					.error(apiError)
					.build();
		}
		return null;
	}

	@GetMapping("/all/{pageNo}/{resultsPerPage}")
	public ApiResponse<List<Player>> getPlayers(
			@PathVariable("pageNo") int pageNo,
			@PathVariable("resultsPerPage") int resultsPerPage) {
		try {
			return  new PagingApiResponseBuilder<>()
					.results(100)
					.pageNo(1)
					.status(ResponseConstant.SUCCESS.name())
					.code(ResponseConstant.SUCCESS.code())
					.dateTime(Calendar.getInstance().getTimeInMillis())
					.message("List fetched successfully")
					.payload(playerService.getPlayer(pageNo, resultsPerPage))
					.build();
		}catch (Exception e) {
			return new ApiResponseBuilder<List<Player>>()
					.status(ResponseConstant.FAILURE.name())
					.code(ResponseConstant.FAILURE.code())
					.error(new ApiErrorBuilder("Exception occurred").errorDetails(e.getMessage()).errorCode("XXX").build())
					.build();
		}
	}
}
