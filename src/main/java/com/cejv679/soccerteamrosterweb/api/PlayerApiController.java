package com.cejv679.soccerteamrosterweb.api;

import com.cejv679.soccerteamrosterweb.db.PlayerNotFoundException;
import com.cejv679.soccerteamrosterweb.db.PlayerRepository;
import com.cejv679.soccerteamrosterweb.domain.Player;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/player")
public class PlayerApiController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";

  private PlayerRepository playerRepository;


    public PlayerApiController() {
    }

  @Autowired
  public PlayerApiController(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }
 
  
  @RequestMapping(value="/{lastname}", method=RequestMethod.GET, produces="application/json")
  public Player playerByLastName(@PathVariable String lastname) {
      final Player findByLastName = playerRepository.findByLastName(lastname);
    return findByLastName;
  }
  
  @RequestMapping(method=RequestMethod.POST, consumes="application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Player> savePlayer(@RequestBody Player player, UriComponentsBuilder ucb) {
    Player saved = playerRepository.save(player);
    
    HttpHeaders headers = new HttpHeaders();
    URI locationUri = ucb.path("/players/")
        .path(String.valueOf(saved.getId()))
        .build()
        .toUri();
    headers.setLocation(locationUri);
    
    ResponseEntity<Player> responseEntity = new ResponseEntity<Player>(saved, headers, HttpStatus.CREATED);
    return responseEntity;
  }
  
  @ExceptionHandler(PlayerNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody Error playerNotFound(PlayerNotFoundException e) {
    long playerId = e.getPlayerId();
    return new Error(4, "Player [" + playerId + "] not found");
  }

}
