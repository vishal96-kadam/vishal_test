package service;




import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import entity.Categories;
import repository.CategoryRepository;
import repository.ProductRepository;

// Annotation
@Service

// Class
public class CategoryServiceImpl
	implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// Save operation
	@Override
	public String saveCategory(Categories category)
	{
		categoryRepository.save(category);
		 return"success";
	}

	// Read operation
	@Override public List<Categories> fetchCategoryList( Pageable paging)
	{
		return (List<Categories>)
				categoryRepository.findAll(paging);
	}

	// Update operation
	@Override
	public Categories
	updateCategory(Categories category)
	{
		
		return categoryRepository.save(category);
	}

	// Delete operation
	@Override
	public void deleteCategoryById(Long categoryId)
	{
		categoryRepository.deleteById(categoryId);
	}

	
	
	public Categories fetchCategoryListById(long id) {
		
	
		Categories depDB
		= categoryRepository.findById(id)
			.get();
		return depDB;
	}

	

	
}
