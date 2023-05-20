package br.com.alexmdo.codecademy.portfolioproject.restaurant;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByNameAndZipCode(String name, String zipCode);
    List<Restaurant> findByZipCodeOrderByOverallScoreDesc(String zipCode);

}
