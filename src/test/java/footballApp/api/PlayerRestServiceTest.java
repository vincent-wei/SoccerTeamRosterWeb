/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballApp.api;

import com.cejv679.soccerteamrosterweb.api.PlayerApiController;
import com.cejv679.soccerteamrosterweb.db.PlayerRepository;
import com.cejv679.soccerteamrosterweb.domain.Player;
import footballApp.config.JpaConfig;
import footballApp.config.WebConfig;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author S.Y Wei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={WebConfig.class,JpaConfig.class})
@WebAppConfiguration
public class PlayerRestServiceTest {
    
        @Autowired
	PlayerRepository playerRepository;
    
        private static final String REST_APP_URL = "http://localhost:8080/SoccerTeamRosterWeb/api/player/";
	private RestTemplate restTemplate = new RestTemplate();
			
	@Test
        @Transactional
	public void findPlayerTest() throws Exception {
            List<Player> players = playerRepository.findAll();
            
            PlayerApiController controller = new PlayerApiController(playerRepository);
    
    MockMvc mockMvc = standaloneSetup(controller).build();
    
    
    MvcResult result = mockMvc.perform(get("/api/player/tester").accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andReturn();

   String content = result.getResponse().getContentAsString();
//		Player createdPlayer = restTemplate.postForObject(REST_APP_URL, createPlayer(), Player.class);
//		
//		// retrieve a representation by doing a GET on the specified URL, 
//		// the response is converted and returned. 
//		Player userFound = restTemplate.getForObject("http://localhost:8080/SoccerTeamRosterWeb/api/player/", Player.class);
//		Assert.assertNotNull(userFound);
//		Assert.assertEquals("Tom", userFound.getName());
//		Assert.assertNotNull(userFound.getId());
	}
	
		
	/**
	 * Construct REST URL for testing.
	 * 
	 * @param user for testing
	 */
	private String createRestAppUrl(Player user) {
		return REST_APP_URL.concat("/").concat(user.getId().toString());
	}
}
