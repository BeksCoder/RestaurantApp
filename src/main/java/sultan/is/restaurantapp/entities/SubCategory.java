package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import lombok.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;

@Entity
@Table(name = "sub_category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@SequenceGenerator(name = "base_id_gen", sequenceName = "sub_category_seq", allocationSize = 1)
public class SubCategory extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
