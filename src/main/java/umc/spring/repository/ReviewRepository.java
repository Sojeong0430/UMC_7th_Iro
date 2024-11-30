package umc.spring.repository;

import org.apache.catalina.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
}
