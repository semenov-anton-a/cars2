/**
 *  @EXAMPLE String Boot 2.5.6
 *  https://roytuts.com/spring-jpa-bidirectional-manytomany-association-without-join-entity/
 */

package cars2.cars2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
// @AllArgsConstructor
@NoArgsConstructor
public class Client extends AbstractPersistable<Integer>{

    @Column
    private String name;
    @Column
    private String surname;

    @ManyToMany(mappedBy="clientCars")
    private List<Car> cars = new ArrayList<>();

    public Client(String name, String surname, List<Car> cars)
    {
        this.name = name;
        this.surname = surname;
    }

    public Client addCar(Car car) {
        this.cars.add(car);
        return this;
    }



}


