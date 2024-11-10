package umc.spring.service.RestaurantService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RestaurantRepository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServicelmpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public Optional<Restaurant> findStore(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findStoresByNameAndScore(String name, Float score) {
        List<Restaurant> filteredStores = restaurantRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(restaurant -> System.out.println("Store: " + restaurant));

        return filteredStores;
    }

}
