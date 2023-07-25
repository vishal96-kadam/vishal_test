
package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import entity.Categories;
import service.CategoryServiceImpl;

@RestController

public class CategoryController {

	// Annotation
	
	@Autowired
	CategoryServiceImpl CategoryServiceImpl;
	
	@GetMapping("/api/categories")
	public String getCategories(@RequestParam(defaultValue = "0", required = false) 
    Integer page ) {
		
        Pageable paging  = PageRequest.of(page, 5) ;

		String jsonStr = JSONArray.toJSONString(CategoryServiceImpl.fetchCategoryList(paging));
		return jsonStr;
	}
	
	@RequestMapping("api/categories" )
	public JSONObject createCategory(Categories  category)
	{
		
		
		
		JSONObject obj=new JSONObject();

	//      String jsonStr = JSONArray.toJSONString(list);

	      obj.put("flag", CategoryServiceImpl.saveCategory(category));
	
	      return obj;
		
	}

	@RequestMapping("api/categories" )
	public JSONObject GetByCatId(@RequestParam int catId
		 )
	{
		JSONObject obj=new JSONObject(); 
		obj.put("Category", CategoryServiceImpl.fetchCategoryListById(catId));
		return obj;
	}

	@PutMapping("api/categories" )
	public Categories updateByCatId(@RequestParam Categories categories
		 )
	{
		return CategoryServiceImpl.updateCategory(categories);
	}
	
	@DeleteMapping("api/categories" )
	public JSONObject DeleteByCatId(@RequestParam long catId
		 )
	{
		JSONObject obj=new JSONObject();
	
		CategoryServiceImpl.deleteCategoryById(catId);
		obj.put("flag", "deleted");
		return  obj;
	}
	
}
