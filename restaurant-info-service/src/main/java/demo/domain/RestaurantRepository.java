package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hectorlueng on 5/25/18.
 */

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // temporarily use exact match
    List<Restaurant> findByName(String name);
}
