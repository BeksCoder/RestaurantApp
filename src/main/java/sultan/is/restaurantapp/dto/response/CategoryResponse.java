package sultan.is.restaurantapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;
    private List<SubcategoryResponse> subcategories;  // Убедитесь, что это поле существует


}
