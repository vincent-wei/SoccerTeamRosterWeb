/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cejv679.soccerteamrosterweb.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
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
public class Statistic {
    
    @Id    
    private Long id;
    @Column
    private int numOfGoals;
    
    @Column
    private int numOfBookings;
    
    @OneToOne(optional = false)
    @JoinColumn(name="player_id",referencedColumnName = "id") //,nullable = false, updatable = false, insertable = false
    @MapsId
    @JsonBackReference
    private Player player;

    public Statistic() {
    }

    
    public Statistic(int numOfGoals, int numOfBookings) {
        this.numOfGoals = numOfGoals;
        this.numOfBookings = numOfBookings;
    }

    public Statistic(Long id, int numOfGoals, int numOfBookings) {
        this.id = id;
        this.numOfGoals = numOfGoals;
        this.numOfBookings = numOfBookings;
    }
    
    
     public Long getId() {
        return id;
     }

    public void setId(Long id) {
        this.id = id;
    }
     
     

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public int getNumOfBookings() {
        return numOfBookings;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }   
    
    
}
