package demo;

import demo.domain.Restaurant;
import demo.domain.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by hectorlueng on 5/25/18.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY, connection = EmbeddedDatabaseConnection.H2)
public class RestaurantRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RestaurantRepository restaurantRepository;

    private String macDonald = "MacDonald";
    private String macDonaldAddress = "1111 25 St";
    private String kentuckey = "Kentuckey";

    @Test
    public void givenOneNotMatched_whenFindByName_thenReturnRestaurant() {
        Restaurant restaurant = new Restaurant(macDonald, macDonaldAddress);
        entityManager.persist(restaurant);
        entityManager.flush();

        List<Restaurant> restaurants = restaurantRepository.findByName(kentuckey);

        assertThat(restaurants).size().isEqualTo(0);
    }

    @Test
    public void givenOne_whenFindByName_thenReturnRestaurant() {
        Restaurant restaurant = new Restaurant(macDonald, macDonaldAddress);
        entityManager.persist(restaurant);
        entityManager.flush();

        List<Restaurant> restaurants = restaurantRepository.findByName(macDonald);

        assertThat(restaurants).size().isEqualTo(1);
        assertThat(restaurants.get(0).getAddress()).isEqualTo(macDonaldAddress);
    }

}
