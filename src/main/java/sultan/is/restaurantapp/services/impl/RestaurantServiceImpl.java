package sultan.is.restaurantapp.services.impl;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sultan.is.restaurantapp.dto.request.RestaurantRequest;
import sultan.is.restaurantapp.dto.response.RestaurantResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.entities.Restaurant;
import sultan.is.restaurantapp.exceptions.ResourceNotFoundException;
import sultan.is.restaurantapp.mapper.RestaurantMapper;
import sultan.is.restaurantapp.repositories.RestaurantRepository;
import sultan.is.restaurantapp.services.RestaurantService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@FieldDefaults(level  = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
      RestaurantRepository restaurantRepository;
      RestaurantMapper restaurantMapper;




    @Override
    @Transactional
    public SimpleResponse saveRestaurant(RestaurantRequest request) {
        Restaurant restaurant = restaurantMapper.toRestaurant(request);
        restaurantRepository.save(restaurant);
        return SimpleResponse.builder().description("saved").status(HttpStatus.CREATED).build();


    }

    @Override
    public List<RestaurantResponse> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurantMapper::toRestaurantResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantResponse getById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Restaurant with id %d not found", id))
        );
        return restaurantMapper.toRestaurantResponse(restaurant);
    }

    @Override
    public SimpleResponse updateRestaurants(Long id, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Restaurant with id %d not found", id))
        );
        restaurantMapper.updateRestaurantFromRequest(request,restaurant);
        restaurantRepository.save(restaurant);
        return new SimpleResponse(HttpStatus.OK, "Restaurant updated successfully with ID: " + restaurant.getId());
    }



    @Override
    public SimpleResponse deleteById(Long id) {
      Restaurant restaurant =   restaurantRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format("Restaurant with id %d not found",id))
        );
      restaurantRepository.delete(restaurant);
        return SimpleResponse.builder().status(HttpStatus.OK).description("deleted").build();
    }
}
