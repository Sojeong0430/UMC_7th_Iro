package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

public interface ReviewCommandService{
    public Review addReview(Long RestaurantId, ReviewRequestDTO.AddReviewDTO request);
}
