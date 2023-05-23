package br.com.alexmdo.codecademy.portfolioproject.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String displayName;
    private String city;
    private String state;
    private String zipcode;
    private boolean peanutAllergyInterest;
    private boolean eggAllergyInterest;
    private boolean dairyAllergyInterest;
    
} 
