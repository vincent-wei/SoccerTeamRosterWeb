package com.cejv679.soccerteamrosterweb.db;

import com.cejv679.soccerteamrosterweb.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author 
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
	  
	Player findByLastName(String lastName);
	

}
