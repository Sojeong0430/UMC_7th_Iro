package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO AddReviewResult(Review review){
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .ReviewID(review.getId())
                .created_At(LocalDateTime.now())
                .build();
    }//응답

    public static Review toReview(Restaurant restaurant, Member member, ReviewRequestDTO.AddReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .reviewBody(request.getReviewBody())
                .restaurant(restaurant)
                .score(request.getScore())
                .member(member)
                .build();
    } //DTO -> Review 객체 생성
}
