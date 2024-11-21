package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    boolean existsByMemberIdAndMissionId(Long MemberId, Long missionId);
}
