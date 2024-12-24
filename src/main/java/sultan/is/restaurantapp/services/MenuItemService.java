package sultan.is.restaurantapp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sultan.is.restaurantapp.dto.request.MenuItemRequest;
import sultan.is.restaurantapp.dto.response.MenuResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;

import java.util.List;

public interface MenuItemService {

    SimpleResponse addMenuItemToRestaurant(Long restaurantId, Long subCategoryId, MenuItemRequest menuItemRequest);

    SimpleResponse deleteMenuItem(Long id);

    SimpleResponse updateMenuItem(Long id,MenuItemRequest menuItemRequest);

    Page<MenuResponse> allMenuItems(Pageable pageable);

   List<MenuResponse> globalSearch(String name);



}
