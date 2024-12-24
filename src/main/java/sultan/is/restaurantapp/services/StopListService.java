package sultan.is.restaurantapp.services;

import sultan.is.restaurantapp.dto.response.SimpleResponse;

public interface StopListService {
    SimpleResponse createStopList(Long menuItemId);

}
