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
public class Clients extends AbstractPersistable<Long>{

    private String name;
    private String surname;

    @ManyToMany
    private List<Cars> cars = new ArrayList<>();

}


