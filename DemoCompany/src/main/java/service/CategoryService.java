
package service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import entity.Categories;
// Interface
public interface CategoryService {

	// Save operation
	String saveCategory(Categories category);

	// Read operation
	List<Categories> fetchCategoryList( Pageable paging);

	
	void deleteCategoryById(Long categoryId);

	Categories updateCategory(Categories category);
}
