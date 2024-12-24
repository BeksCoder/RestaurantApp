package sultan.is.restaurantapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sultan.is.restaurantapp.dto.request.SubCategoryRequest;
import sultan.is.restaurantapp.entities.SubCategory;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    @Query("select s from SubCategory s where s.category.id = :categoryId order by s.name asc ")
    List<SubCategory> findSubCategoriesByCategoryIdSorted(@Param("categoryId") Long categoryId);

    List<SubCategory> findByCategoryId(Long categoryId, Sort sort);

    @Query("update SubCategory s set  where s.id = :id")
    @Modifying
    void updateSubCategoryById(Long id,SubCategoryRequest subCategoryRequest);


    Page<SubCategory> findAll(Pageable pageable);
}
