package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.MemberMissionDTO.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge/{MissionId}")
    public ApiResponse<MissionResponseDTO.AddMemberMissionResultDTO> AddMemberMission(@ExistMemberMission @PathVariable("MissionId") Long MissionId){
        MemberMission memberMission = missionCommandService.AddMemberMission(MissionId);
        return ApiResponse.onSuccess(MemberMissionConverter.addMemberMissionResultDTO(memberMission));
    }// 도전중인 미션 추가

    @GetMapping("/{RestaurantId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "RestaurantId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이징 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreviewListDTO> getReviewList(@PathVariable(name = "RestaurantId") Long restaurantId,@CheckPage @RequestParam(name = "page") Integer page){
        Page<Mission> missionList =  missionCommandService.getMissionList(restaurantId,page-1);
        return ApiResponse.onSuccess(MissionConverter.missionPreviewListDTO(missionList));
    }//특정 가게의 미션 목록 조회

    @GetMapping("/challenge/member/{MemberId}")
    @Operation(summary = "내가 진행 중인 미션 목록 API",description = "내가 진행중인 미션의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "MemberId", description = "회원 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreViewListDTO> getMemberMissionList(@PathVariable(name = "MemberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = memberMissionCommandService.getMemberMissionList(memberId,page-1);
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreViewListDTO(memberMissionList));
    }//내가 진행중인 미션 목록 조회

    @PatchMapping("/complate/{MemberMissionId}")
    @Operation(summary = "진행중인 미션 진행 완료로 바꾸기 API",description = "진행중인 미션 진행 완료로 바꾸기 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "MemberMissionId", description = " 도전 중인 미션 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.MemberMissionPreviewDTO> MemberMissionToComplate(@PathVariable(name = "MemberMissionId") Long memberMissionId){
        MemberMission memberMission = memberMissionCommandService.MemberMissionToComplete(memberMissionId);
        return ApiResponse.onSuccess(MemberMissionConverter.memberMissionPreviewDTO(memberMission));
    }//진행중인 미션 진행 완료로 바꾸기
}
