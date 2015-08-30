/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cejv679.soccerteamrosterweb.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author S.Y Wei
 */
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;
    
    @Column
    private String CountryOfBirth;
    @Column(name="field_position")
    private String position;
    
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "player")
    @JsonManagedReference
    private Salary salary;
  
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "player")
    @JsonManagedReference
    private Statistic stats;

    public Player() {
    }
    
    public Player(String firstName, String lastName, int age, String CountryOfBirth, String position, Salary salary, Statistic stats) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.CountryOfBirth = CountryOfBirth;
        this.position = position;
        this.salary = salary;
        this.stats = stats;
    }
    
    public Long getId() {
    return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Salary getSalary() {
        return salary;
    }

    public String getCountryOfBirth() {
        return CountryOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public Statistic getStats() {
        return stats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountryOfBirth(String CountryOfBirth) {
        this.CountryOfBirth = CountryOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public void setStats(Statistic stats) {
        this.stats = stats;
    }
    
    
    
    
}
