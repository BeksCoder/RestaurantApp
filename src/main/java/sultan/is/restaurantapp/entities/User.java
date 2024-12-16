package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import lombok.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;
import sultan.is.restaurantapp.enums.Role;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "base_id_gen", sequenceName = "user_seq", allocationSize = 1)
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    private int  experience;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;




}
