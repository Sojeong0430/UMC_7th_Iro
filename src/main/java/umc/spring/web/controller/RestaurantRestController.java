package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;
import umc.spring.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantDTO.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final MissionCommandService missionCommandService;
    @PostMapping("/{regionId}")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> AddRestaurant(@PathVariable("regionId") Long regionId, @RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request){
        Restaurant restaurant = restaurantCommandService.addRestaurantToRegion(regionId,request);
        return ApiResponse.onSuccess(RestaurantConverter.AddRestaruantResult(restaurant));
    } //가게 추가하기

    @PostMapping("/mission/{restaurantId}")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> AddMission(@PathVariable("restaurantId") Long restaurantId, @RequestBody @Valid MissionRequestDTO.AddMissionDTO request){
        Mission mission = missionCommandService.AddMission(restaurantId,request);
        return ApiResponse.onSuccess(MissionConverter.AddMissionResultDTO(mission));
    }//가게에 미션 추가하기

}
