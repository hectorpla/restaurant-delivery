package demo.service.impl;

import demo.domain.Restaurant;
import demo.domain.RestaurantRepository;
import demo.rest.RestaurantInfoServiceController;
import demo.service.RestaurantSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hectorlueng on 5/25/18.
 */

@Service
public class RestaurantSearchServiceImpl implements RestaurantSearchService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantSearchServiceImpl(RestaurantRepository repository) {
        this.restaurantRepository = repository;
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        return restaurantRepository.findByName(name);
    }
}
