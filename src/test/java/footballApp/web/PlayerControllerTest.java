package footballApp.web;

import com.cejv679.soccerteamrosterweb.db.PlayerRepository;
import com.cejv679.soccerteamrosterweb.web.PlayerController;
import footballApp.config.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class PlayerControllerTest {
    
    @Autowired
	PlayerRepository playerRepository;

  @Test
  public void shouldShowRegistration() throws Exception {
    PlayerController controller = new PlayerController();
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/createplayer"))
           .andExpect(view().name("createplayerForm"));
  }
  
  @Test
  public void shouldProcessRegistration() throws Exception {
       //PlayerRepository mockRepository = mock(PlayerRepository.class); 
    PlayerController controller = new PlayerController(playerRepository);
    
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(post("/createplayer")
           .param("firstName", "Jack")
           .param("lastName", "Bauer")
           .param("age", "24")
           .param("countryOfBirth", "Canada")
           .param("position", "Goalkeeper")
           .param("amount", "100000")
           .param("numOfGoals", "12")
           .param("numOfBookings", "1")
           .param("create", "Create")
    )
           .andExpect(view().name("playerdetails"));
    
  }
  @Test
  public void shouldCancelRegistration() throws Exception {
    PlayerController controller = new PlayerController();    
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(post("/createplayer")
           .param("firstName", "Jack")
           .param("lastName", "Bauer")
           .param("age", "24")
           .param("countryOfBirth", "Canada")
           .param("position", "Goalkeeper")
           .param("amount", "100000")
           .param("numOfGoals", "12")
           .param("numOfBookings", "1")
           .param("cancel", "Cancel")
    )
           .andExpect(redirectedUrl("/"));
    
  }  

//  @Test
//  public void shouldFailValidationWithNoData() throws Exception {
//    PlayerController controller = new PlayerController();
//    MockMvc mockMvc = standaloneSetup(controller).build();    
//    mockMvc.perform(post("/createplayer")
////           .param("firstName", "Jack1")
////           .param("lastName", "Bauer")
////           .param("age", "15")
////           .param("countryOfBirth", "Canada")
////           .param("position", "Goalkeeper")
////           .param("amount", "100000")
////           .param("numOfGoals", "12")
////           .param("numOfBookings", "1")
//            .param("create", "Create")
//    
//    ).andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(view().name("createplayerForm"))
////        .andExpect(model().errorCount(1))
////        .andExpect(model().attributeHasFieldErrors(
////            "firstName", "lastName", "age", "countryOfBirth", "position","amount","numOfGoals","numOfBookings"))
//            ;
//           
//  }

}
