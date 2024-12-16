package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import lombok.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;

import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@SequenceGenerator(name = "base_id_gen", sequenceName = "category_seq", allocationSize = 1)
public class Category extends BaseEntity {
    private String name;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubCategory> subcategories;



}
