package demo;

import demo.domain.MenuItem;
import demo.domain.MenuItemRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by hectorlueng on 5/26/18.
 */

@RunWith(SpringRunner.class)
public class MenuItemRepositoryImplTest {

//    public static @ClassRule
//    RuleChain rules = RuleChain
//            .outerRule(EmbeddedRedisServer.runningAt(6379).suppressExceptions())
//            .around(RequiresRedisServer.onLocalhost().atLeast("3.2"));

    // assure that there is a local redis server

    @Autowired
    private MenuItemRepository repository;

    private final static long testRestaurant = 1;
    private final static MenuItem orangeChicken = new MenuItem(122, "orange chicken", 12.3);
    private final static List<MenuItem> menu = new ArrayList<>();

    @BeforeClass
    public static void setup() {
        menu.add(orangeChicken);
    }

    @Before
    public void cleanup() {
        repository.purge(testRestaurant);
    }

    @Test
    public void givenOneItem_whenFindAll_thenReturnOne() {
        repository.add(testRestaurant, orangeChicken);

        assertThat(repository.findAll(testRestaurant)).isEqualTo(menu);
    }
}
