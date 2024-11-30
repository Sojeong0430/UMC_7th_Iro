package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.*;
import umc.spring.domain.Mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Mission AddMission(Long restaurantId,MissionRequestDTO.AddMissionDTO request){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() ->new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        Mission newMission = MissionConverter.toMission(restaurant,request);
        missionRepository.save(newMission);
        return newMission;
    }// 가게에 미션 추가
    @Override
    @Transactional
    public MemberMission AddMemberMission(Long MissionId){
        Mission mission = missionRepository.findById(MissionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        Member member = memberRepository.findById(3L).orElseThrow(() -> new RuntimeException("존재하는 회원이 없습니다"));
        MemberMission memberMission = MemberMissionConverter.toMemberMission(member,mission);
        memberMissionRepository.save(memberMission);
        return memberMission;
    }//도전중인 미션 추가

    @Override
    @Transactional
    public Page<Mission> getMissionList(Long RestaurantId, Integer page){
        Restaurant restaurant = restaurantRepository.findById(RestaurantId).get();
        Page<Mission> RestaurantPage = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page,10));
        return RestaurantPage;
    } //미션 목록 조회
}
