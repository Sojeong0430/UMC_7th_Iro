package umc.spring.web.dto.RestaurantDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Region;

import java.time.LocalDateTime;

public class RestaurantResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRestaurantResultDTO{
        Long RestaurantId;
        String name;
        LocalDateTime createdAt;
    }
}
