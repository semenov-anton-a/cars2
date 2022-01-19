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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Car extends AbstractPersistable<Integer> {

    // @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private Long id;

    @Column
    private String vin;
    @Column
    private String reg;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String year;

    @ManyToMany
    @JoinTable(name = "client_car", 
        joinColumns = @JoinColumn(name = "car_id"), 
        inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clientCars = new ArrayList<>();


    public Car(String vin, String brand, String model, String reg, String year, List<Client> clients) 
    {
        this.vin    = vin;
        this.brand  = brand;
        this.model  = model;
        this.reg    = reg;
        this.year   = year;
    }

}
