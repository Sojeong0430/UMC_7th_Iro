package umc.spring.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.store;
import umc.spring.domain.generated.Qstore;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private JPAQueryFactory jpaQueryFactory;
    private final Qstore store = Qstore.store;

    @Override
    public List<store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.name.eq(name));
        }

        if (score != null) {
            predicate.and(store.score.goe(4.0f));
        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}