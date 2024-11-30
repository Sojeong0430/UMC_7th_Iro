package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mapping.MemberMission;


public interface MemberMissionCommandService {
    Page<MemberMission> getMemberMissionList(Long MemberId, Integer page);
    public MemberMission MemberMissionToComplete(Long MissionId);
}
