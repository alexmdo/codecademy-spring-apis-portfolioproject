package br.com.alexmdo.codecademy.portfolioproject.diningreview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {

    List<DiningReview> findByStatus(DiningReview.Status status);

    List<DiningReview> findByRestaurantIdAndStatus(Long restaurantId, DiningReview.Status status);

}
