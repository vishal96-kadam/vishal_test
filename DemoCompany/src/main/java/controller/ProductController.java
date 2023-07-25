
package controller;
import java.util.*;
import org.json.simple.*;
import java.util.List;
// Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import entity.Categories;
import entity.Product;
import service.ProductService;
import service.ProductServiceImpl;

@RestController

public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	

	
	@GetMapping("/api/categories")
	public String getCategories(@RequestParam(defaultValue = "0", required = false) 
    Integer page ) {
		Pageable paging  = PageRequest.of(page, 5) ;
		
		String jsonStr = JSONArray.toJSONString(productServiceImpl.fetchProductList(paging));
		return jsonStr;
	}
	
	@RequestMapping("api/categories" )
	public JSONObject createCategory(Product  product)
	{
		
		
		
		JSONObject obj=new JSONObject();

	//      String jsonStr = JSONArray.toJSONString(list);

	      obj.put("flag", productServiceImpl.saveProduct(product));
	
	      return obj;
		
	}

	@RequestMapping("api/categories" )
	public JSONObject GetByCatId(@RequestParam int catId
		 )
	{
		JSONObject obj=new JSONObject(); 
		obj.put("Category", productServiceImpl.fetchProductListById(catId));
		return obj;
	}

	@PutMapping("api/categories" )
	public Product updateByCatId(@RequestParam Product category
		 )
	{
		return productServiceImpl.updateProduct(category);
	}
	
	@DeleteMapping("api/categories" )
	public JSONObject DeleteByCatId(@RequestParam long catId
		 )
	{
		JSONObject obj=new JSONObject();
	
		productServiceImpl.deleteProductById(catId);
		obj.put("flag", "deleted");
		return  obj;
	}
	
}
