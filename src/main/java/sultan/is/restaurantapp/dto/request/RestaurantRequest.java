package sultan.is.restaurantapp.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import sultan.is.restaurantapp.enums.RestType;
public record RestaurantRequest(
        String name,
        String location,
        RestType restType,
        Integer numberOfEmployees,
        String service
) {
}
