package sultan.is.restaurantapp.services;

import sultan.is.restaurantapp.dto.request.RestaurantRequest;
import sultan.is.restaurantapp.dto.response.RestaurantResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;

import java.util.List;

public interface RestaurantService {

    SimpleResponse saveRestaurant(RestaurantRequest request);

    List<RestaurantResponse> getRestaurants();

    RestaurantResponse getById(Long id);

    SimpleResponse updateRestaurants(Long id,RestaurantRequest request);

    SimpleResponse deleteById(Long id);




}
