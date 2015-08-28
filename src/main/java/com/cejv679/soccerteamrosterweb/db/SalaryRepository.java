package com.cejv679.soccerteamrosterweb.db;

import com.cejv679.soccerteamrosterweb.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SalaryRepository extends JpaRepository<Salary, Long> {
	  
	

}
