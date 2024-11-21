package umc.spring.service.RestaurantService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.RestaurantDTO.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final RegionRepository regionRepository;
    private final RestaurantRepository restaurantRepository;
    @Override
    @Transactional
    public Restaurant addRestaurantToRegion(Long regionId, RestaurantRequestDTO.AddRestaurantDTO request) {

        Region region = regionRepository.findById(regionId).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));// 지역 ID로 지역을 찾아옴
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(region,request); //converter
        restaurantRepository.save(newRestaurant);

        return newRestaurant;

    } // 지역별 레스토랑 추가
}
