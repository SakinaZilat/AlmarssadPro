package com.marssadpro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marssadpro.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>
{
	
	List<Player> findByLastName(String lastname);
	
	List<Player> findByLastNameAndFirstName(String lastname, String firstname);
	
	Optional<Player> findById(Long id);
	
//	@Transactional
//	@Modifying
	@Query("delete from Player p where p.id= ?1")
	int deletePlayerById(Long id);
	
}
