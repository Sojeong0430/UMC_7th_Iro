package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreviewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .content(mission.getMissionBody())
                .reward(mission.getReward())
                .deadLine(mission.getDeadline())
                .build();
    }//개별 미션 DTO 생성

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO (Page<Mission> missionList){

        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }//미션 List 생성
}
