package com.marssadpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marssadpro.domain.Player;
import com.marssadpro.service.PlayerService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/{version}/marssadpro", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController
{
	@Autowired
	private PlayerService playerService;
	
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> getAllPlayers(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
			)
	{
		List<Player> playerList = playerService.findAll();
		return new ResponseEntity<>(playerList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/player", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Player create(@RequestBody Player player, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
	{
		return playerService.add(player);
		
	}	
	
	@RequestMapping(value = "/players/searchByLastname/{lastname}", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> getPlayersByLastName(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "lastname") @PathVariable("lastname") String lastname
			)
	{
		List<Player> playerList = playerService.findPlayersByLastName(lastname);
		return new ResponseEntity<>(playerList, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/players/searchByNames/{lastname}/{firstname}", method = RequestMethod.GET)
	public ResponseEntity<List<Player>> getPlayersByLastNameAndFistName(
			@ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(name = "lastname") @PathVariable("lastname") String lastname,
			@ApiParam(name = "firstname") @PathVariable("firstname") String firstname
			)
	{
		List<Player> playerList = playerService.findPlayersByLastNameAndFistName(lastname, firstname);
		return new ResponseEntity<>(playerList, HttpStatus.OK);		
	}
}
