package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    public Mission AddMission(Long restaurantId,MissionRequestDTO.AddMissionDTO request);
}
