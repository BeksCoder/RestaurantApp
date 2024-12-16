package sultan.is.restaurantapp.mapper;

import org.mapstruct.Mapper;
import sultan.is.restaurantapp.dto.request.RestaurantRequest;
import sultan.is.restaurantapp.dto.response.RestaurantResponse;
import sultan.is.restaurantapp.entities.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantResponse toRestaurantResponse(Restaurant restaurant);

    Restaurant toRestaurant(RestaurantRequest restaurantRequest);
}

