package br.com.alexmdo.codecademy.portfolioproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    
    private Long id;
    private String name;
    private String address;
    private Float peanutScore;
    private Float eggScore;
    private Float dairyScore;
    private Float overallScore;
    
}

