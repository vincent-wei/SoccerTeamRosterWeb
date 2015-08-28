package com.cejv679.soccerteamrosterweb.db;

public class PlayerNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  private long playerId;

  public PlayerNotFoundException(long playerId) {
    this.playerId = playerId;
  }
  
  public long getPlayerId() {
    return playerId;
  }
  
}
