package footballApp.web;

import com.cejv679.soccerteamrosterweb.web.TrainerController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TrainerControllerTest {

  @Test
  public void shouldShowRegistration() throws Exception {
    TrainerController controller = new TrainerController();
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/createtrainer"))
           .andExpect(view().name("createtrainerForm"));
  }
  
  @Test
  public void shouldProcessRegistration() throws Exception {
    TrainerController controller = new TrainerController();
    
    MockMvc mockMvc = standaloneSetup(controller).build();

    mockMvc.perform(post("/createtrainer")
           .param("firstName", "Jack")
           .param("lastName", "Bauer")
           .param("age", "24")
           .param("countryOfBirth", "Canada")
           .param("position", "Goalkeeper")
           .param("amount", "100000")          
           .param("create", "Create")
    )
           .andExpect(view().name("trainerdetails"));
    
  }
  @Test
  public void shouldCancelRegistration() throws Exception {
    TrainerController controller = new TrainerController();    
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(post("/createtrainer")
           .param("firstName", "Jack")
           .param("lastName", "Bauer")
           .param("age", "24")
           .param("countryOfBirth", "Canada")
           .param("position", "Goalkeeper")
           .param("cancel", "Cancel")
    )
           .andExpect(redirectedUrl("/"));
    
  }  

//  @Test
//  public void shouldFailValidationWithNoData() throws Exception {
//    TrainerController controller = new TrainerController();
//    MockMvc mockMvc = standaloneSetup(controller).build();    
//    mockMvc.perform(post("/createtrainer")
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
//        .andExpect(view().name("createtrainerForm"))
////        .andExpect(model().errorCount(1))
////        .andExpect(model().attributeHasFieldErrors(
////            "firstName", "lastName", "age", "countryOfBirth", "position","amount","numOfGoals","numOfBookings"))
//            ;
//           
//  }

}
