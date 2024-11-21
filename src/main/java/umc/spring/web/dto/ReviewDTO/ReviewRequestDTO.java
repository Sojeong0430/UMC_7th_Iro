package umc.spring.web.dto.ReviewDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDTO{
        @NotNull
        String title;
        @NotNull
        String reviewBody;
        @NotNull
        Float score;
    }
}