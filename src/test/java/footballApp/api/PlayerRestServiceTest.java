/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballApp.api;

import com.cejv679.soccerteamrosterweb.api.PlayerApiController;
import com.cejv679.soccerteamrosterweb.db.PlayerRepository;
import footballApp.config.JpaConfig;
import footballApp.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author S.Y Wei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, JpaConfig.class})
@WebAppConfiguration
public class PlayerRestServiceTest {

    @Autowired
    PlayerRepository playerRepository;
 

    @Test
    @Transactional
    public void findPlayerTest() throws Exception {
        PlayerApiController controller = new PlayerApiController(playerRepository);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/api/player/tester")) //.accept(MediaType.APPLICATION_JSON)) not needed. why?
                .andDo(print())
                .andExpect(content().string("{\"id\":1,\"firstName\":\"tester\",\"lastName\":\"tester\",\"age\":16,"
                                + "\"position\":\"Midfielder\",\"salary\":{\"id\":1,\"amount\":1000},\"stats\":{\"id\":1,"
                                + "\"numOfGoals\":10,\"numOfBookings\":1},\"countryOfBirth\":\"Canada\"}"));
    }

}