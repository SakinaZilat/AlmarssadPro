package com.marssadpro.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marssadpro.domain.Player;
import com.marssadpro.repository.PlayerRepository;

@Service
public class PlayerService
{
	@Autowired
	private PlayerRepository playerRepository;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);
	
	public Player add(Player player)	
	{
		String upperCaseName = player.getFirstName().toUpperCase();
		player.setFirstName(upperCaseName);
		
		// or we can do it this way
		player.setLastName(player.getLastName().toUpperCase());
		
		return this.playerRepository.save(player);
	}
	
	public List<Player> findAll()
	{
		return this.playerRepository.findAll();
	}
	
	
	public List<Player> findPlayersByLastName(String lastName)
	{
		return this.playerRepository.findByLastName(lastName);
	}
	
	public List<Player> findPlayersByLastNameAndFistName(String lastName, String firstName)
	{
		return this.playerRepository.findByLastNameAndFirstName(lastName, firstName);
	}
	
}
