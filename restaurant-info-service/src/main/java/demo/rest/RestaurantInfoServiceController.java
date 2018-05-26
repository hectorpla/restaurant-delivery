package demo.rest;

import demo.domain.Restaurant;
import demo.service.RestaurantSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hectorlueng on 5/25/18.
 */

@RestController
public class RestaurantInfoServiceController {

    RestaurantSearchService searchService;

    @Autowired
    RestaurantInfoServiceController(RestaurantSearchService restaurantSearchService) {
        this.searchService = restaurantSearchService;
    }

    @RequestMapping(path = "/restaurants/name/:name", method = RequestMethod.GET)
    List<Restaurant> findRestaurant(@PathVariable String name) {
        return this.searchService.findRestaurantByName(name);
    }
}
