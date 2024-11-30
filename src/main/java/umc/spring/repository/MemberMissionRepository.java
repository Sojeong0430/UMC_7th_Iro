package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.enums.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    boolean existsByMemberIdAndMissionId(Long MemberId, Long missionId);
    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);
}
