package cars2.cars2.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Cars extends AbstractPersistable<Long>{

    private String vin;
    private String reg;
    private String brand;
    private String model;
    private String year;

    @ManyToMany(mappedBy="cars")
    private List<Clients> clients = new ArrayList<>();

}
