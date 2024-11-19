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
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    @PostMapping("/{regionId}")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> AddRestaurant(@PathVariable("regionId") Long regionId, @RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request){

        Restaurant restaurant = restaurantCommandService.addRestaurantToRegion(regionId,request);

        return ApiResponse.onSuccess(RestaurantConverter.AddRestaruantResult(restaurant));
    }
}
