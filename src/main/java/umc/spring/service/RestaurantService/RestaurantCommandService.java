package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantDTO.RestaurantRequestDTO;

public interface RestaurantCommandService {
    public Restaurant addRestaurantToRegion(Long regionId, RestaurantRequestDTO.AddRestaurantDTO request); //지역별 레스토랑 추가
}
