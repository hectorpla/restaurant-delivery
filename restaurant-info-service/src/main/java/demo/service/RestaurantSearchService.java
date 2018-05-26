package demo.service;

import demo.domain.Restaurant;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by hectorlueng on 5/25/18.
 */

public interface RestaurantSearchService {
    List<Restaurant> findRestaurantByName(String name);
}
