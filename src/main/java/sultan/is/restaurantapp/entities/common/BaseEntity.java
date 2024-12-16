package sultan.is.restaurantapp.entities.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public  abstract  class BaseEntity {
    @Id
    @GeneratedValue(generator = "base_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

}
