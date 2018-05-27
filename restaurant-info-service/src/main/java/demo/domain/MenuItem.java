package demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

/**
 * Created by hectorlueng on 5/25/18.
 */

@RedisHash("Item")
@AllArgsConstructor
@Data
public class MenuItem {

    // should be synced with the restaurant side
    private int id;
    private String dishName;
    private double price;

    public MenuItem() {}
}
