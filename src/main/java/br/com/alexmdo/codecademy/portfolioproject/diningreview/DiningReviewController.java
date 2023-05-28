package br.com.alexmdo.codecademy.portfolioproject.diningreview;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/dining-reviews")
@RequiredArgsConstructor
public class DiningReviewController {

    private final DiningReviewService diningReviewService;

    @PostMapping
    public ResponseEntity<DiningReview> submitDiningReview(@RequestBody DiningReview diningReview,
            @RequestParam String userDisplayName) {
        var submittedReview = diningReviewService.submitDiningReview(diningReview, userDisplayName);
        return ResponseEntity.status(HttpStatus.CREATED).body(submittedReview);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<DiningReview>> getPendingDiningReviews() {
        var pendingReviews = diningReviewService.getPendingDiningReviews();
        return ResponseEntity.ok(pendingReviews);
    }

    @PutMapping("/{diningReviewId}/approve")
    public ResponseEntity<Void> approveDiningReview(@PathVariable Long diningReviewId) {
        diningReviewService.approveDiningReview(diningReviewId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{diningReviewId}/reject")
    public ResponseEntity<Void> rejectDiningReview(@PathVariable Long diningReviewId) {
        diningReviewService.rejectDiningReview(diningReviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/approved")
    public ResponseEntity<List<DiningReview>> getApprovedDiningReviewsByRestaurant(@RequestParam Long restaurantId) {
        var approvedReviews = diningReviewService.getApprovedDiningReviewsByRestaurant(restaurantId);
        return ResponseEntity.ok(approvedReviews);
    }
    
}
