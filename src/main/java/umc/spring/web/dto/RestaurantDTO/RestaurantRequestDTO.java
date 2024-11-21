package umc.spring.web.dto.RestaurantDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.domain.Region;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO{
        @NotNull
        String name; //이름
        @NotNull
        String address; //주소
    }
}
