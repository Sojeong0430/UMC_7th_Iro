package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistRestraurant;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;
import umc.spring.web.dto.RestaurantDTO.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantDTO.RestaurantResponseDTO;
import umc.spring.web.dto.ReviewDTO.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;
    private final MissionCommandService missionCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping("/{regionId}") //post
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> AddRestaurant(@PathVariable("regionId") Long regionId, @RequestBody @Valid RestaurantRequestDTO.AddRestaurantDTO request){
        Restaurant restaurant = restaurantCommandService.addRestaurantToRegion(regionId,request);
        return ApiResponse.onSuccess(RestaurantConverter.AddRestaruantResult(restaurant));
    } //가게 추가하기

    @PostMapping("/mission/{restaurantId}") //post
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> AddMission(@PathVariable("restaurantId") Long restaurantId, @RequestBody @Valid MissionRequestDTO.AddMissionDTO request){
        Mission mission = missionCommandService.AddMission(restaurantId,request);
        return ApiResponse.onSuccess(MissionConverter.AddMissionResultDTO(mission));
    }//가게에 미션 추가하기

    @GetMapping("/{restaurantId}/reviews") //get
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestraurant @PathVariable(name = "restaurantId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = restaurantQueryService.getReviewList(storeId,page-1);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }// 작성한 리뷰 조회
}
