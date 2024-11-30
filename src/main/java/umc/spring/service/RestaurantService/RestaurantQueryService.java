package umc.spring.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface RestaurantQueryService {
    Page<Review> getReviewList(Long StoredId, Integer page);
}
