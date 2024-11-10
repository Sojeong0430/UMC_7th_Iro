package umc.spring.repository.RestaurantRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QRestaurant;
import umc.spring.domain.Restaurant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositorylmpl implements RestaurantRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QRestaurant restaurant = QRestaurant.restaurant;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder(); //BooleanBuilder

        if (name != null) {
            predicate.and(restaurant.name.eq(name));
        } //조건 동적으로 추가

        if (score != null) {
            predicate.and(restaurant.score.goe(4.0f));
        } //조건 동적으로 추가

        return jpaQueryFactory
                .selectFrom(restaurant)
                .where(predicate)
                .fetch();
    }
}
