package service;




import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import entity.Categories;
import entity.Product;
import repository.ProductRepository;

// Annotation
@Service

// Class
public class ProductServiceImpl
	implements ProductService {

	@Autowired
	private ProductRepository categoryRepository;

	// Save operation
	@Override
	public String saveProduct(Product product)
	{
		 categoryRepository.save(product);
		 return"success";
	}

	@Override public List<Product> fetchProductList(Pageable paging)
	{
		return (List<Product>)
			categoryRepository.findAll(paging);
	}

	@Override
	public Product
	updateProduct(Product product)
	{
		
		return categoryRepository.save(product);
	}

	// Delete operation
	@Override
	public void deleteProductById(Long productId)
	{
		categoryRepository.deleteById(productId);
	}

	
	
	public Product fetchProductListById(long id) {
		
		
		Product depDB
		= categoryRepository.findById(id)
			.get();
		return depDB;
	}

	

	
}
