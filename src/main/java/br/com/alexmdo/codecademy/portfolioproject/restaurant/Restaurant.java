package br.com.alexmdo.codecademy.portfolioproject.restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    private String zipCode;
    private Float peanutScore;
    private Float eggScore;
    private Float dairyScore;
    private Float overallScore;
    
}

