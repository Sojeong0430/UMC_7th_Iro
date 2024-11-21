package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistRestraurant;
import umc.spring.web.dto.ReviewDTO.ReviewRequestDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    @PostMapping("/{restaurantId}")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> AddReview(@ExistRestraurant @PathVariable("restaurantId") Long restaurantId, @RequestBody @Valid ReviewRequestDTO.AddReviewDTO request){

        Review review = reviewCommandService.addReview(restaurantId,request);

        return ApiResponse.onSuccess(ReviewConverter.AddReviewResult(review));
    } //리뷰 작성


}
