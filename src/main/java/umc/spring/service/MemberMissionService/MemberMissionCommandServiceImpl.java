package umc.spring.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;

import static umc.spring.domain.enums.MissionStatus.CHALLENGING;
import static umc.spring.domain.enums.MissionStatus.COMPLETE;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMemberMissionList(Long MemberId, Integer page){
        Member member = memberRepository.findById(3L).get();
        Page<MemberMission> MemberMissionPage =  memberMissionRepository.findAllByMemberAndStatus(member,CHALLENGING,PageRequest.of(page,10));
        return MemberMissionPage;
    }//내가 도전 중인 미션 조회

    @Override
    public MemberMission MemberMissionToComplete(Long MemberMissionId){
        MemberMission memberMission = memberMissionRepository.findById(MemberMissionId).get();
        memberMission.setStatus(MissionStatus.COMPLETE);
        memberMissionRepository.save(memberMission);
        return memberMission;
    }//미션 상태 완료로 변경

}
