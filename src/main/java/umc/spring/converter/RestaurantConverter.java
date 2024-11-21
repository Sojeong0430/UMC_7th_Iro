package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantDTO.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantResponseDTO.AddRestaurantResultDTO AddRestaruantResult(Restaurant restaurant){
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .RestaurantId(restaurant.getId())
                .name(restaurant.getName())
                .createdAt(LocalDateTime.now())
                .build();
    } //응답

    public static Restaurant toRestaurant(Region region, RestaurantRequestDTO.AddRestaurantDTO request){

        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();

    }//DTO -> Restaurant 객체 생성
}
