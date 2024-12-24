package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import sultan.is.restaurantapp.entities.common.BaseEntity;

import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@SequenceGenerator(name = "base_id_gen", sequenceName = "category_seq", allocationSize = 1)
@EntityListeners(AuditingEntityListener.class)
public class Category extends BaseEntity {
    private String name;


    @OneToMany(mappedBy = "category", cascade = PERSIST,orphanRemoval = true)
    private List<SubCategory> subcategories;



}
