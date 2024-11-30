package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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


    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getReviewBody())
                .build();
    }
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
