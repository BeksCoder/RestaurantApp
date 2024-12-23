package sultan.is.restaurantapp.dto.request;

import sultan.is.restaurantapp.enums.RestType;
public record RestaurantRequest(
        String name,
        String location,
        RestType restType,
        Integer numberOfEmployees,
        String service
) {
}
