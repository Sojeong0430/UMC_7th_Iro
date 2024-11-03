package umc.spring.repository.StoreRepository;
import umc.spring.domain.store;
import java.util.List;
public interface StoreRepositoryCustom {

    List<store> dynamicQueryWithBooleanBuilder(String name, Float score);

}
