package demo.service;

import demo.domain.MenuItem;

import java.util.List;

/**
 * Created by hectorlueng on 5/25/18.
 */

public interface MenuService {
    MenuItem addItem(long id, MenuItem item);
    MenuItem deleteItem(long id, MenuItem item);
    List<MenuItem> addItems(long restaurantId, List<MenuItem> items);
    List<MenuItem> update(long restaurantId, List<MenuItem> items);
    List<MenuItem> reset(long restaurantId, List<MenuItem> items);
}
