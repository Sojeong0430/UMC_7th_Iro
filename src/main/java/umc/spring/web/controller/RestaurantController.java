package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantDTO.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Restaurant")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService; //서비스(생성자 주입됨)

    @PostMapping("/{regionId}")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> AddRestaurant(@PathVariable("regionId") Long regionId, @RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request){

        Restaurant restaurant = restaurantCommandService.addRestaurantToRegion(regionId,request); //파라미터의 지역 ID 받기, requestDTO 받아서 서비스로 넘기기

        return ApiResponse.onSuccess(RestaurantConverter.AddRestaruantResult(restaurant));
    }
}
