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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
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

    @ManyToMany
    @JoinTable(name = "client_car", 
        joinColumns = @JoinColumn(name = "client_id"), 
        inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> clientCars = new ArrayList<>();

    public Client(String name, String surname, List<Car> cars)
    {
        this.name = name;
        this.surname = surname;
    }

}


