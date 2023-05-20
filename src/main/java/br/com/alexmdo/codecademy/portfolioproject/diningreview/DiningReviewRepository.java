package br.com.alexmdo.codecademy.portfolioproject.diningreview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexmdo.codecademy.portfolioproject.diningreview.DiningReview.Status;

public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {

    List<DiningReview> findByStatus(Status status);
    List<DiningReview> findByRestaurantIdAndStatus(Long restaurantId, Status status);

}
