package sultan.is.restaurantapp.dto.request;

import lombok.Builder;
import sultan.is.restaurantapp.entities.SubCategory;

import java.util.List;

@Builder
public record CategoryRequest(
        String name,
        List<SubCategory> subCategories
) {
}
