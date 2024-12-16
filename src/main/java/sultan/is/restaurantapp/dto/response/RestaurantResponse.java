package sultan.is.restaurantapp.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sultan.is.restaurantapp.enums.RestType;

@Getter
@AllArgsConstructor
public class RestaurantResponse {
    private Long id;
    private String name;
    private String location;
    private RestType restType;
    private Integer numberOfEmployees;
    private String service;
}
