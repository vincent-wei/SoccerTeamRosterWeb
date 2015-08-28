package com.cejv679.soccerteamrosterweb.db;

import com.cejv679.soccerteamrosterweb.domain.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
	  
	

}
