package com.marssadpro.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marssadpro.domain.Player;
import com.marssadpro.service.PlayerService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/{version}/marssadpro/players", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController
{
	@Autowired
	private PlayerService playerService;
	
	/**
	* Find all Players
	*/
	@GetMapping
	public ResponseEntity<Collection<Player>> findAllPlayers(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	{
		Collection<Player> foundPlayers = playerService.findAllPlayers();
		return ResponseEntity.ok(foundPlayers);
	}
	
	/**
	 * Find Player by id
	 */
	@GetMapping("/{playerId}")
	public ResponseEntity<Player> findPlayer(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, @ApiParam(name = "playerId") @PathVariable Long playerId)
	{
		Player foundPlayer = playerService.findPlayerById(playerId);
		return ResponseEntity.ok(foundPlayer);
	}
	
	/**
	 * Create a new Player or update/overwrite existing
	 */
	@PostMapping
	public ResponseEntity<Player> createOrUpdatePlayer(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, @ApiParam(name = "player") @RequestBody Player player)
	{
		Player createdPlayer = playerService.createPlayer(player);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPlayer);
		
	}
	
	/**
	 * Delete selected Player
	 */
	@DeleteMapping("/{playerId}")
	public ResponseEntity<String> deletePlayer(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, @ApiParam(name = "playerId") @PathVariable Long playerId)
	{
		playerService.deletePlayer(playerId);
		return ResponseEntity.ok("The Player with id: " + playerId + " was deleted with success.");
		
	}
	
	/**
	 * Update specific fields on selected Player
	 */
	@PutMapping("/{playerId}")
	public ResponseEntity<Player> partialUpdatePlayer(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, @ApiParam(name = "player") @RequestBody Player player, @ApiParam(name = "playerId") @PathVariable Long playerId)
	{
		Player updatedPlayer = playerService.updatePlayer(player, playerId);
		return ResponseEntity.ok(updatedPlayer);
	}
	
	@GetMapping("/searchByLastname/{lastname}")
	public ResponseEntity<List<Player>> getPlayersByLastName(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, @ApiParam(name = "lastname") @PathVariable("lastname") String lastname)
	{
		List<Player> playerList = playerService.findPlayersByLastName(lastname);
		return new ResponseEntity<>(playerList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/players/searchByNames/{lastname}/{firstname}")
	public ResponseEntity<List<Player>> getPlayersByLastNameAndFistName(@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version, @ApiParam(name = "lastname") @PathVariable("lastname") String lastname, @ApiParam(name = "firstname") @PathVariable("firstname") String firstname)
	{
		List<Player> playerList = playerService.findPlayersByLastNameAndFistName(lastname, firstname);
		return new ResponseEntity<>(playerList, HttpStatus.OK);
	}
	
	//	@RequestMapping(value = "/player", method = RequestMethod.GET)
	//	public ResponseEntity<List<Player>> getAllPlayers(
	//			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
	//			)
	//	{
	//		List<Player> playerList = playerService.findAll();
	//		return new ResponseEntity<>(playerList, HttpStatus.OK);		
	//	}
	//	
	//	@RequestMapping(value = "/player", method = RequestMethod.POST)
	//	@ResponseStatus(HttpStatus.CREATED)
	//	public Player create(@RequestBody Player player, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	//	{
	//		return playerService.add(player);
	//		
	//	}	
	//	
	//	@RequestMapping(value = "/players/searchByLastname/{lastname}", method = RequestMethod.GET)
	//	public ResponseEntity<List<Player>> getPlayersByLastName(
	//			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
	//			@ApiParam(name = "lastname") @PathVariable("lastname") String lastname
	//			)
	//	{
	//		List<Player> playerList = playerService.findPlayersByLastName(lastname);
	//		return new ResponseEntity<>(playerList, HttpStatus.OK);		
	//	}
	//	
	//	@RequestMapping(value = "/players/searchByNames/{lastname}/{firstname}", method = RequestMethod.GET)
	//	public ResponseEntity<List<Player>> getPlayersByLastNameAndFistName(
	//			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
	//			@ApiParam(name = "lastname") @PathVariable("lastname") String lastname,
	//			@ApiParam(name = "firstname") @PathVariable("firstname") String firstname
	//			)
	//	{
	//		List<Player> playerList = playerService.findPlayersByLastNameAndFistName(lastname, firstname);
	//		return new ResponseEntity<>(playerList, HttpStatus.OK);		
	//	}
}
