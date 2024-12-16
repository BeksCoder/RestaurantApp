package sultan.is.restaurantapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sultan.is.restaurantapp.entities.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}
