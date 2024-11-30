package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {
    public Mission AddMission(Long restaurantId,MissionRequestDTO.AddMissionDTO request);
    public MemberMission AddMemberMission(Long MissionId);
    Page<Mission> getMissionList(Long RestaurantId, Integer page);
}
