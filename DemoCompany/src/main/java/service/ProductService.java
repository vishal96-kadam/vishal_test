
package service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import entity.Categories;
import entity.Product;
// Interface
public interface ProductService {

	String saveProduct(Product category);

	List<Product> fetchProductList(Pageable paging);

	
	void deleteProductById(Long categoryId);

	Product updateProduct(Product category);
}
