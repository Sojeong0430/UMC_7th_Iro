package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.store;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServicelmpl implements StoreQueryService {

    private StoreRepository storeRepository;

    @Override
    public Optional<store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<store> findStoresByNameAndScore(String name, Float score) {
        List<store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;

    }
}