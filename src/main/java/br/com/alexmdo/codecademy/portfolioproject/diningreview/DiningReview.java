package br.com.alexmdo.codecademy.portfolioproject.diningreview;

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
public class DiningReview {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String submitterDisplayName;
    private Long restaurantId;
    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;
    private String commentary;
    private Status status;

    public enum Status {
        PENDING,
        ACCEPTED,
        REJECTED
    }

}
