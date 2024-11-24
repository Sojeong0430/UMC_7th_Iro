package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(storeId).get();
        Page<Review> RestaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page,10));
        return RestaurantPage;
    }
}
