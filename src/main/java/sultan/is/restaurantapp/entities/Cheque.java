package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cheque_lsit")
@SequenceGenerator(name = "base_id_gen", sequenceName = "cheque_seq", allocationSize = 1)
public class Cheque extends BaseEntity {
    private double priceAverage;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cheque_menuitem",
            joinColumns = @JoinColumn(name = "cheque_id"),
            inverseJoinColumns = @JoinColumn(name = "menuitem_id")
    )
    private List<MenuItem> menuItems;

}
