package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    @PostMapping("/challenge/{MissionId}")
    public ApiResponse<MissionResponseDTO.AddMemberMissionResultDTO> AddMemberMission(@ExistMemberMission @PathVariable("MissionId") Long MissionId){
        MemberMission memberMission = missionCommandService.AddMemberMission(MissionId);
        return ApiResponse.onSuccess(MemberMissionConverter.addMemberMissionResultDTO(memberMission));
    }// 도전중인 미션 추가
}
