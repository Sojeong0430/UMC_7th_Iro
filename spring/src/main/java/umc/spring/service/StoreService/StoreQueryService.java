package umc.spring.service.StoreService;

import umc.spring.domain.store;

import java.util.Optional;
import java.util.List;

public interface StoreQueryService {
    Optional<store> findStore(Long id);
    List<store> findStoresByNameAndScore(String name, Float score);
}
