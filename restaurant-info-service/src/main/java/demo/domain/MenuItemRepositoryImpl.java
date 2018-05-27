package demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by hectorlueng on 5/25/18.
 */

@Repository
public class MenuItemRepositoryImpl implements MenuItemRepository {

    private RedisTemplate<Long, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public MenuItemRepositoryImpl(RedisTemplate<Long, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void add(long restaurantId, final MenuItem item) {
        hashOperations.put(restaurantId, item.getId(), item);
    }

    @Override
    public void add(long restaurantId, final List<MenuItem> items) {
        for (MenuItem item: items) {
            add(restaurantId, item);
        }
    }

    @Override
    public void delete(long restaurantId, int itemId) {
        hashOperations.delete(restaurantId, itemId);
    }

    @Override
    public void update(long restaurantId, List<MenuItem> items) {
        // alternative: putAll()
        for (MenuItem item: items) {
            if (hashOperations.hasKey(restaurantId, item.getId())) {
                hashOperations.put(restaurantId, item.getId(), item);
            }
        }
    }

    @Override
    public void purge(long restaurantId) {
        // weird, hashOperations.keys() should return Set<Long>
        for (Object itemId: hashOperations.keys(restaurantId)) {
            hashOperations.delete(restaurantId, (Long)itemId);
        }
    }

    @Override
    public Map<Object, Object> findAll(long restaurantId) {
        return hashOperations.entries(restaurantId);
    }
}
