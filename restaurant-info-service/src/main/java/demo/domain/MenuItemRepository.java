package demo.domain;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by hectorlueng on 5/25/18.
 */

//@Repository
public interface MenuItemRepository {

    Map<Object, Object> findAll(long restaurantId);
    void add(long restaurantId, MenuItem item);
    void add(long restaurantId, List<MenuItem> items);
    void delete(long restaurantId, int id);
    void update(long restaurantId, List<MenuItem> items);
    void purge(long restaurantId);
}
