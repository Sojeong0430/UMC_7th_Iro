package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.AddMissionResultDTO AddMissionResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }//응답

    public static Mission toMission(Restaurant restaurant, MissionRequestDTO.AddMissionDTO request) {
        return Mission.builder()
                .restaurant(restaurant)
                .missionBody(request.getMissionBody())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .build();
    }//DTO -> Mission 객체 생성
}
