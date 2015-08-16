/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cejv679.soccerteamrosterweb;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


/**
 *
 * @author S.Y Wei
 */
public class TrainerForm {
    
    @NotNull
    @Pattern(regexp = "^[^0-9]+$")
    String firstName;
    @NotNull
    @Pattern(regexp = "^[^0-9]+$")
    String lastName;
    
    @NotNull
    @NumberFormat(style = Style.NUMBER)
    @Min(1)
    @Max(110)
    int age;
  
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int amount;
    
    @NotNull
    String countryOfBirth;

       
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }    
    
        public int getAmount() {
        return amount;
    }
   
    public String getCountryOfBirth() {
        return countryOfBirth;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }
    
    
}
