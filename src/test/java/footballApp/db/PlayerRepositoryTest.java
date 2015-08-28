package footballApp.db;

import com.cejv679.soccerteamrosterweb.db.PlayerRepository;
import com.cejv679.soccerteamrosterweb.db.SalaryRepository;
import com.cejv679.soccerteamrosterweb.db.StatisticRepository;
import com.cejv679.soccerteamrosterweb.domain.Player;
import com.cejv679.soccerteamrosterweb.domain.Salary;
import com.cejv679.soccerteamrosterweb.domain.Statistic;
import footballApp.config.JpaConfig;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class PlayerRepositoryTest {

	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	SalaryRepository salaryRepository;
	@Autowired
	StatisticRepository statisticRepository;
	
	@Test
	@Transactional
	public void count() {
		assertEquals(4, playerRepository.count());
	}
	

	@Test
	@Transactional
	public void findByLastName() {
		assertPlayer(0, playerRepository.findByLastName("tester"));
		assertPlayer(1, playerRepository.findByLastName("sester"));
		assertPlayer(2, playerRepository.findByLastName("dester"));
		assertPlayer(3, playerRepository.findByLastName("fester"));
	}
        
        @Test
	@Transactional
	public void findAll() {
		List<Player> players = playerRepository.findAll();
		assertEquals(4, players.size());
		assertPlayer(0, players.get(0));
		assertPlayer(1, players.get(1));
		assertPlayer(2, players.get(2));
		assertPlayer(3, players.get(3));
	}
	
		
	@Test
	@Transactional        
	public void save_newPlayer() {
		assertEquals(4, playerRepository.count());
//		Salary sal = salaryRepository.save(new Salary(5000));
		Salary sal = new Salary(5000);
		Statistic stat = new Statistic(10, 2);
//		Statistic stat = statisticRepository.save(new Statistic(10, 2));
//		Player player = new Player("newbee", "new", 50, "USA", "Goalkeeper",sal ,stat );
		Player player = new Player("newbee", "new", 50, "USA", "Goalkeeper",sal ,stat);
                sal.setPlayer(player);
                stat.setPlayer(player);
		Player saved = playerRepository.save(player);
		assertEquals(5, playerRepository.count());
		List<Player> players = playerRepository.findAll();
		assertPlayer(4, saved);
		assertPlayer(4, playerRepository.findByLastName("new"));
	}

	
	
	private static void assertPlayer(int expectedPlayerIndex, Player actual) {
		Player expected = players[expectedPlayerIndex];
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getAge(), actual.getAge());
		assertEquals(expected.getCountryOfBirth(), actual.getCountryOfBirth());
		assertEquals(expected.getPosition(), actual.getPosition());
		assertEquals(expected.getStats().getNumOfBookings(), actual.getStats().getNumOfBookings());
		assertEquals(expected.getStats().getNumOfGoals(), actual.getStats().getNumOfGoals());
		assertEquals(expected.getSalary().getAmount(), actual.getSalary().getAmount());
	}
	
	private static Player[] players = new Player[6];
	
	@BeforeClass
	public static void before() {
		players[0] = new Player("tester", "tester", 16, "Canada", "Midfielder", new Salary(1000),new Statistic(10, 1));
		players[1] = new Player("sester", "sester", 16, "Canada", "Midfielder", new Salary(2000),new Statistic(11, 1));
		players[2] = new Player("dester", "dester", 16, "Canada", "Midfielder", new Salary(3000),new Statistic(12, 1));
		players[3] = new Player("fester", "fester", 16, "Canada", "Midfielder", new Salary(4000),new Statistic(13, 1));		
		players[4] = new Player("newbee", "new", 50, "USA", "Goalkeeper", new Salary(5000),new Statistic(10, 2));		
	}
	
}
