package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review addReview(Long RestaurantId, ReviewRequestDTO.AddReviewDTO request){

        Restaurant restaurant = restaurantRepository.findById(RestaurantId).orElseThrow(() ->new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        Member member = memberRepository.findById(3L).orElseThrow(() -> new RuntimeException("Member with ID 3 not found"));
        Review newReview = ReviewConverter.toReview(restaurant,member,request);
        reviewRepository.save(newReview);
        return newReview;
    } // 가게에 리뷰 추가
}
