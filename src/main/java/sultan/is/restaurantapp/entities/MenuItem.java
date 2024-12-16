package sultan.is.restaurantapp.entities;

import jakarta.persistence.*;
import lombok.*;
import sultan.is.restaurantapp.entities.common.BaseEntity;

import java.util.List;

@Entity
@Table(name = "menuItems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@SequenceGenerator(name = "base_id_gen", sequenceName = "menu_seq", allocationSize = 1)

public class MenuItem extends BaseEntity {
    private Long id;
    private String name;
    private String image;
    private Double price;
    private String description;
    private boolean isVegetarian;

    @ManyToMany(mappedBy = "menuItems")
    private List<Cheque> cheques;


    @OneToOne
    @JoinColumn(name = "stoplist_id")
    private StopList stopList;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subcategory;


}
