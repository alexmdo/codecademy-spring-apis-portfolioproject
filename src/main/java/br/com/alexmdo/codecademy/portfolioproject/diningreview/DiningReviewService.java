package br.com.alexmdo.codecademy.portfolioproject.diningreview;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alexmdo.codecademy.portfolioproject.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiningReviewService {

    private final DiningReviewRepository diningReviewRepository;
    private final UserRepository userRepository;

    @Transactional
    public DiningReview submitDiningReview(DiningReview diningReview, String userDisplayName) {
        var user = userRepository.findByDisplayName(userDisplayName);
        if (!user.isPresent()) {
            throw new IllegalArgumentException("User not found.");
        }

        // Set the user and status for the dining review
        diningReview.setSubmitterDisplayName(userDisplayName);
        diningReview.setStatus(DiningReview.Status.PENDING);

        return diningReviewRepository.save(diningReview);
    }

    public List<DiningReview> getPendingDiningReviews() {
        return diningReviewRepository.findByStatus(DiningReview.Status.PENDING);
    }

    @Transactional
    public void approveDiningReview(Long diningReviewId) {
        var diningReview = diningReviewRepository.findById(diningReviewId)
                .orElseThrow(() -> new IllegalArgumentException("Dining review not found."));

        diningReview.setStatus(DiningReview.Status.ACCEPTED);
        diningReviewRepository.save(diningReview);
    }

    @Transactional
    public void rejectDiningReview(Long diningReviewId) {
        var diningReview = diningReviewRepository.findById(diningReviewId)
                .orElseThrow(() -> new IllegalArgumentException("Dining review not found."));

        diningReview.setStatus(DiningReview.Status.REJECTED);
        diningReviewRepository.save(diningReview);
    }

    public List<DiningReview> getApprovedDiningReviewsByRestaurant(Long restaurantId) {
        return diningReviewRepository.findByRestaurantIdAndStatus(restaurantId, DiningReview.Status.ACCEPTED);
    }
    
}
