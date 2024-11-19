package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Mission AddMission(Long restaurantId,MissionRequestDTO.AddMissionDTO request){

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() ->new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        Mission newMission = MissionConverter.toMission(restaurant,request);
        missionRepository.save(newMission);
        return newMission;
    }// 가게에 미션 추가
}
