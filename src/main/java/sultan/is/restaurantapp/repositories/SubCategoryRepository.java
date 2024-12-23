package sultan.is.restaurantapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sultan.is.restaurantapp.entities.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
