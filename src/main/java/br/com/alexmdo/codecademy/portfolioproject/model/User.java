package br.com.alexmdo.codecademy.portfolioproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private Long id;
    private String displayName;
    private String city;
    private String state;
    private String zipcode;
    private boolean peanutAllergyInterest;
    private boolean eggAllergyInterest;
    private boolean dairyAllergyInterest;
    
} 
