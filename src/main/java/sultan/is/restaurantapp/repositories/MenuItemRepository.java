package sultan.is.restaurantapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sultan.is.restaurantapp.entities.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
