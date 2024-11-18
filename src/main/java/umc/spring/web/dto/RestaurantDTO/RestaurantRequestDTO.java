package umc.spring.web.dto.RestaurantDTO;

import lombok.Getter;
import umc.spring.domain.Region;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO{
        String name; //이름
        String address; //주소
    }
}
