package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

// mind that all dependencies are from javax.persistence
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hectorlueng on 5/25/18.
 */

// ORM, Json mapping

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String address;

    public Restaurant() {}

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
