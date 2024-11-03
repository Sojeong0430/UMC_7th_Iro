package umc.spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.store;

import java.util.List;
public interface StoreRepository extends JpaRepository<store, Long>, StoreRepositoryCustom {

}
