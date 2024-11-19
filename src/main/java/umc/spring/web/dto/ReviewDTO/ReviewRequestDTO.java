package umc.spring.web.dto.ReviewDTO;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDTO{
        String title;
        String reviewBody;
        Float score;
    }
}