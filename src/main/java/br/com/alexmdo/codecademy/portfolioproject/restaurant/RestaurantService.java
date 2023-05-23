package br.com.alexmdo.codecademy.portfolioproject.restaurant;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        // Check if a restaurant with the same name and zip code already exists
        var existingRestaurant = restaurantRepository.findByNameAndZipCode(restaurant.getName(),
                restaurant.getZipCode());
        if (existingRestaurant.isPresent()) {
            throw new IllegalArgumentException("Restaurant with the same name and zip code already exists.");
        }
        
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found."));
    }

    public List<Restaurant> getRestaurantsByZipCodeAndAllergy(String zipCode, String allergy) {
        switch (allergy) {
            case "peanut":
                return restaurantRepository.findByZipCodeAndPeanutScoreNotNullOrderByPeanutScoreDesc(zipCode);
            case "egg":
                return restaurantRepository.findByZipCodeAndEggScoreNotNullOrderByEggScoreDesc(zipCode);
            case "dairy":
                return restaurantRepository.findByZipCodeAndDairyScoreNotNullOrderByDairyScoreDesc(zipCode);
            default:
                throw new IllegalArgumentException("Invalid allergy.");
        }
    }
    
}
