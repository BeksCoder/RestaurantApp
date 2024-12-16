package sultan.is.restaurantapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;

import java.time.LocalDate;
@Entity
@Table(name = "stop_list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@SequenceGenerator(name = "base_id_gen", sequenceName = "stopList_seq", allocationSize = 1)
public class StopList extends BaseEntity {
    private String reason;
    private LocalDate date;

}
