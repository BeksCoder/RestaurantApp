package sultan.is.restaurantapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import sultan.is.restaurantapp.dto.request.RestaurantRequest;
import sultan.is.restaurantapp.dto.response.RestaurantResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.services.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @Operation(
            summary = "This saves a Restaurant",
            description = "This method validates and saves restaurant data")
    @ApiResponse(responseCode = "201", description = "Restaurant successfully created")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/save")
    SimpleResponse save(@RequestBody RestaurantRequest restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }
    @GetMapping("/all")
    public List<RestaurantResponse> findAllRestaurants(){
       return restaurantService.getRestaurants();
    }
}
