// Java Program to Illustrate DepartmentRepository File

package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Categories;

// Annotation
@Repository

// Interface
public interface CategoryRepository
	extends JpaRepository<Categories, Long> {
}
