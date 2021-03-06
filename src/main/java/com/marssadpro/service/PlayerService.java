package com.marssadpro.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.marssadpro.domain.Player;
import com.marssadpro.exceptions.PlayerNotFoundException;
import com.marssadpro.repository.PlayerRepository;

@Service
public class PlayerService
{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);
	@Autowired
	private PlayerRepository playerRepository;
	
	public Collection<Player> findAllPlayers()
	{
		Collection<Player> foundPlayers = playerRepository.findAll();
		
		return foundPlayers;
		
	}
	
	public Player findPlayerById(Long playerId)
	{
		Optional<Player> player = playerRepository.findById(playerId);
		return player.orElseThrow(() -> new PlayerNotFoundException(playerId));
	}
	
	@Transactional
	public Player createPlayer(Player player)
	{
		updateData(player);
		return playerRepository.save(player);
	}
	
	private void updateData(Player player)
	{
		if (player.getRegistredDate() == null)
		{
			player.setRegistredDate(new Date());
		}
		if (player.getAge() == null)
		{
			LocalDate bday = player.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate today = LocalDate.now();
			Period age = Period.between(bday, today);
			int years = age.getYears();
			
			player.setAge(Math.toIntExact(years));
		}
	}
	
	public void deletePlayer(Long playerId)
	{
		playerRepository.delete(playerId);
		
	}
	
	public Player updatePlayer(@RequestBody Player player, long playerId)
	{
		// get selected Player or throw an error
		Player playerFromDB = findPlayerById(playerId);
		if (playerFromDB.getId() != 0)
		{
			updateData(player);
			
			return playerRepository.save(player);
		}
		else
		{
			return null;
		}
		
	}
	
	public List<Player> findPlayersByLastName(String lastName)
	{
		return this.playerRepository.findByLastName(lastName);
	}
	
	public List<Player> findPlayersByLastNameAndFistName(String lastName, String firstName)
	{
		return this.playerRepository.findByLastNameAndFirstName(lastName, firstName);
	}

	public List<Player> findPlayersByClubCountry(String clubCountry) {
		return this.playerRepository.findByClubCountry(clubCountry);
	}
	
	//	public Player add(Player player)
	//	{
	//		String upperCaseName = player.getFirstName().toUpperCase();
	//		player.setFirstName(upperCaseName);
	//		
	//		// or we can do it this way
	//		player.setLastName(player.getLastName().toUpperCase());
	//		
	//		return this.playerRepository.save(player);
	//	}
	//	
	//	public List<Player> findAll()
	//	{
	//		return this.playerRepository.findAll();
	//	}
	//	
	//	public List<Player> findPlayersByLastName(String lastName)
	//	{
	//		return this.playerRepository.findByLastName(lastName);
	//	}
	//	
	//	public List<Player> findPlayersByLastNameAndFistName(String lastName, String firstName)
	//	{
	//		return this.playerRepository.findByLastNameAndFirstName(lastName, firstName);
	//	}
	//	
	//	public void deletePlayerById(long id)
	//	{
	//		Player player = playerRepository.findOne(id);
	//		playerRepository.delete(player);
	//		
	//	}
	
}
