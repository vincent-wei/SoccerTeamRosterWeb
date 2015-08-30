/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cejv679.soccerteamrosterweb.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 *
 * @author S.Y Wei
 */

@Entity
public class Salary {
    @Id
    private Long id;
     
    private int amount;
    
    @OneToOne(optional = false)
    @JoinColumn(name="player_id",referencedColumnName = "id") //nullable = false, updatable = false, insertable = false
    @MapsId
    @JsonBackReference
    private Player player;

    public Salary() {
    }

    public Salary(Long id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    
    public Salary(int amount) {
        this.amount = amount;
    }
    
     public Long getId() {
    return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    

    public int getAmount() {
        return amount;
    }    

    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
}
