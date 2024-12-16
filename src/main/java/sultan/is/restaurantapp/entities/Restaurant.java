package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import lombok.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;
import sultan.is.restaurantapp.enums.RestType;

import java.util.List;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@SequenceGenerator(name = "base_id_gen", sequenceName = "restaurant_seq", allocationSize = 1)
public class Restaurant extends BaseEntity {
    private String name;
    private String location;
    @Enumerated(EnumType.STRING)
    private RestType restType;
    private Integer numberOfEmployees;
    private String service;
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Cheque> cheques;


}
